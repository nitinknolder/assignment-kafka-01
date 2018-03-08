package edu.knoldus.conversions

import java.io.{ByteArrayOutputStream, ObjectOutputStream}
import java.util

import edu.knoldus.studentdatabase.StudentData
import org.apache.kafka.common.serialization.Serializer

class StudentDataSerialization extends Serializer[StudentData] {

  override def configure (configs: util.Map[String, _], isKey: Boolean): Unit = {

  }


  def serialize (topic: String, data: StudentData): Array[Byte] = {
    try {
      val byteOutStream = new ByteArrayOutputStream ()
      val objOutStream = new ObjectOutputStream (byteOutStream)
      objOutStream.writeObject (data)
      objOutStream.close ()
      byteOutStream.close ()
      byteOutStream.toByteArray
    }
    catch {
      case msg: Exception => throw new Exception (msg.getMessage)
    }
  }

  override def close (): Unit = {}


}
