package edu.knoldus.studentdatabase

case class StudentData (studentId: String, studentName: String) {
  override def toString: String = s"Student Id: $studentId,StudentName: $studentName"
}
