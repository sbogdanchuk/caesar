import scala.io.Source

object App {
  def main(args: Array[String]) {
    val path = if(!args.isEmpty)args(0)else "text.txt"
    println(s"Loading: ${path}")
    val text = {
      if(!args.isEmpty)
        Source.fromFile(path).getLines().mkString(" ")
      else
        Source.fromResource(path).getLines().mkString(" ")
    }
    val decryptor = new Decryptor(text)
    println(s"Using ${decryptor.name}")
    println(s"Stat ${decryptor.stat}")

    println(s"Original text: ${text}")

    (0 to 25).map(n => decryptor.shiftText(n)).foreach(println)
  }
}
