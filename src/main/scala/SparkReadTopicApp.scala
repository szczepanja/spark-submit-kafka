import org.apache.spark.sql.{DataFrame, SparkSession}

object SparkReadTopicApp extends App {

  val spark: SparkSession = SparkSession
    .builder()
    .master("local[*]")
    .appName("SparkReadTopicApp")
    .config("spark.some.config.option", "some-value")
    .getOrCreate()

  val topic = if (args.length > 0) args(0) else "input"

  val records: DataFrame = spark
    .readStream
    .format("kafka")
    .option("kafka.bootstrap.servers", ":9092")
    .option("subscribe", topic)
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
