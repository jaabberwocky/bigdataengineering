# tobias leong
from pyspark import SparkContext
from pyspark import SparkConf

# setup sc
conf = SparkConf().setAll([(u'spark.rdd.compress', u'True'), (u'spark.serializer.objectStreamReset', u'100'), (
    u'spark.master', u'local[*]'), (u'spark.submit.deployMode', u'client'), (u'spark.app.name', u'PySparkShell')])
sc = SparkContext(conf=conf)

# load files
data_file = "hdfs://quickstart.cloudera/user/cloudera/data.txt"
text_file = sc.textFile(data_file)

# run count and save in RDD
counts = text_file.flatMap(lambda line: line.split(" ")).map(
    lambda word: (word, 1)).reduceByKey(lambda a, b: a+b)
counts.saveAsTextFile(
    "hdfs://quickstart.cloudera/user/cloudera/data_counts.txt")
