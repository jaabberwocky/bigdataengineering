package sqlsamples

import org.apache.spark._
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types.{StructType, StringType,DoubleType, StructField}

object SparkSampling {
  def main(args:Array[String]): Unit = {
    val conf = new SparkConf()
      .setMaster("local[2]")
      .setAppName("SparkSampling")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._
    val schemaString =
      "Loan_ID,Gender,Married,Dependents,Education, Self_Employed,ApplicantIncome, CoapplicantIncome,LoanAmount,Loan_Amount_Term, Credit_History,Property_Area, Loan_Status"
      val schema = schemaString.split(",").map {
      field =>
      if (field == "ApplicantIncome" || field ==
      "CoapplicantIncome" || field ==
      "LoanAmount" || field ==
      "Loan_Amount_Term" || field == "Credit_History")
      StructField(field, DoubleType)
      else
      StructField(field, StringType)
      }
      val schema_Applied = StructType(schema)
      val loan_Data =
      sqlContext.read.format("com.databricks.spark.csv")
      .option("header", "true")
      .schema(schema_Applied).load("/home/cloudera/git/BEAD/W04-Statistics/data/Loan_Prediction_Data.csv")
      // Generating Sample data (10%) without replacement
      val sampled_Data1 = loan_Data.sample(false, 0.1)
      println("Sample Data Row Count (without Replacement): "+sampled_Data1.count)
      // Generating Sample data (10%) with replacement
      val sampled_Data2 = loan_Data.sample(true, 0.2)
      println("Sample Data Row Count (with Replacement): "+sampled_Data2.count)
      }
}