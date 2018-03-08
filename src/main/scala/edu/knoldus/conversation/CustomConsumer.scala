package edu.knoldus.conversation

import java.util.Properties

import edu.knoldus.studentdatabase.StudentData
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.log4j.Logger

import scala.collection.JavaConverters._

object CustomConsumer extends App {

  val logger = Logger.getLogger (this.getClass)
  val properties = new Properties ()
  properties.put ("bootstrap.servers", "localhost:9092")
  properties.put ("auto.offset.reset", "earliest")
  properties.put ("enable.auto.commit", "false")
  properties.put ("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  properties.put ("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  properties.put ("group.id", "message")


  val consumer = new KafkaConsumer[String, StudentData](properties)
  consumer.subscribe (java.util.Collections.singletonList ("kafkaAssignment1"))
  while (true) {

    //It check after every 5 seconds that if data is present than it will display on console.
    val value = 5000
    val records = consumer.poll (value)
    for (record <- records.asScala)
      logger.info (record.value ())
  }
logger.info("Data received by Consumer...")
}
