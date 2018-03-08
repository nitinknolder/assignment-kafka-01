package edu.knoldus.conversions

import java.io.{ByteArrayInputStream, ObjectInputStream}
import java.util

import edu.knoldus.studentdatabase.StudentData
import org.apache.kafka.common.serialization.Deserializer

class StudentDataDeserialization extends Deserializer[StudentData] {

  override def configure (configs: util.Map[String, _], isKey: Boolean): Unit = {}


  override def deserialize (topic: String, bytes: Array[Byte]): StudentData = {
    val byteInputStream = new ByteArrayInputStream (bytes)
    val objInputStream = new ObjectInputStream (byteInputStream)
    val readObj = objInputStream.readObject ().asInstanceOf[StudentData]
    byteInputStream.close ()
    objInputStream.close ()
    readObj
  }

  override def close (): Unit = {

  }


}
