import org.apache.spark.sql.SparkSession

object SparkReadTopicApp extends App {

  val spark = SparkSession
    .builder
    .master("local[*]")
    .appName("StructuredNetworkWordCount")
    .getOrCreate()

  val records = spark
    .readStream
    .format("kafka")
    .option("kafka.bootstrap.servers", ":9092")
    .option("subscribe", "input")
    .load()

}
