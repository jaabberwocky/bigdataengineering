package sqlsamples

import org.apache.spark._
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.sql._
import org.apache.spark.sql.functions._

object SparkSummaryStats {
  
   def main(args:Array[String]): Unit = {
    val conf = new SparkConf()
      .setMaster("local[2]")
      .setAppName("SparkVariableIdentification")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._
    val loan_Data = sqlContext.read.format ("com.databricks.spark.csv")
      .option("header","true")
      .option("inferSchema", "true")
      .load("/home/cloudera/git/BEAD/W04-Statistics/Loan_Prediction_Data.csv")
      
      // Gets summary of all numeric fields
    val summary = loan_Data.describe()
    summary.show()
    // Get Summary on subset of columns
    val summary_subsetColumns =
      loan_Data.describe("ApplicantIncome", "Loan_Amount_Term")
    summary_subsetColumns.show()

    // Get subset of statistics
    val subset_summary = loan_Data.select(mean("ApplicantIncome"), min("ApplicantIncome"), max("ApplicantIncome"))
    subset_summary.show()

    val selected_Df =
      loan_Data.select("ApplicantIncome","CoapplicantIncome", "LoanAmount")
    selected_Df.show()

    val observations = selected_Df.rdd.map{
      row =>
        val applicantIncome = row.getInt(0)
        val co_applicantIncome = row.getDouble(1)
        val loan_Amount = if(row.isNullAt(2)) 0.0 else row.getInt(2)
        Vectors.dense(applicantIncome, co_applicantIncome,loan_Amount)}
    val summary1 = Statistics.colStats(observations)
    println("Mean: "+summary1.mean)
    println("Variance: "+summary1.variance)
    println("Num of Non-zeros: "+summary1.numNonzeros)
  
   }
  
}