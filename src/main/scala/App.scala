import scala.io.Source

object App {
  def main(args: Array[String]) {
    val default = "text.txt"
    val text = {
      if(!args.isEmpty) {
        val path = args(0)
        println(s"Loading: ${path}")
        Source.fromFile(path).getLines().mkString(" ")
      }
      else {
        println(s"Loading: ${default}")
        Source.fromResource(default).getLines().mkString(" ")
      }
    }
    val decryptor = new Decryptor(text)
    println(s"Using ${decryptor.name}")
    println(s"Stat ${decryptor.stat}")

    println(s"Original text: ${text}")

    (0 to 25).map(n => decryptor.shiftText(n)).foreach(println)
  }
}
