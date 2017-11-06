class Decryptor(text:String) extends ShiftedAlpha{
  val name = "Decryptor"
  val stat = s"Text size: ${text.size}"
  val lower =text.toLowerCase
  def shiftsToString:String = {
    (0 to 48).map(i=>shift(i)).mkString("\n")
  }

  def shiftText(n:Int):String = {
    val currentShift = shift(n)
    (s"Shift[${alpha(n)}]  ") +
    lower.toList.map((ch:Char)=>ch match {
      case ' ' => ' '
      case _ => currentShift.get(ch).get
    }).mkString
  }

}
