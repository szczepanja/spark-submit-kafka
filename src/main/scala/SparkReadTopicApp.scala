import org.apache.spark.sql.{DataFrame, SparkSession}

object SparkReadTopicApp extends App {

  val spark: SparkSession = SparkSession
    .builder()
    .master("local[*]")
    .appName("SparkReadTopicApp")
    .config("spark.some.config.option", "some-value")
    .getOrCreate()

  val records: DataFrame = spark
    .readStream
    .format("kafka")
    .option("kafka.bootstrap.servers", ":9092")
    .option("subscribe", "input")
    .load()

  import spark.implicits._

  val newValue = records.select('value cast ("string"))

  newValue
    .writeStream
    .format("console")
    .option("truncate", value = false)
    .start()
    .awaitTermination()

}
