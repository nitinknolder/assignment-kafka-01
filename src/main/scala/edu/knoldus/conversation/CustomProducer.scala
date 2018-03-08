package edu.knoldus.conversation

import java.util.Properties

import edu.knoldus.studentdatabase.StudentData
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.log4j.Logger

object CustomProducer extends App {

  val logger = Logger.getLogger (this.getClass);
  val listOfStudent = List ("Nitin", "Vinay", "Ayush", "Shubham", "Deepankar")
  val properties = new Properties ()
  properties.put ("bootstrap.servers", "localhost:9092")
  properties.put ("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  properties.put ("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")


  val producer = new KafkaProducer[String, StudentData](properties)
  for (index <- 0 until listOfStudent.size) {
    val key = index.toString

    val value = StudentData (key, listOfStudent (index))

    val record = new ProducerRecord[String, StudentData]("KafkaAssignment1", key, value)
    producer.send (record)
  }
}
