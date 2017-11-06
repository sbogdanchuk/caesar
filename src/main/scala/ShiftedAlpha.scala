import scala.collection.immutable.ListMap

trait ShiftedAlpha {
  val alpha = ('a' to 'z').toList
  protected val shiftedM: Map[Int, Map[Char, Char]] = {
    val circularAlpha = Iterator.continually('a' to 'z').flatten
    (0 to 25).map(shift => {
      val shifted = circularAlpha.take(1 + 26).toList
      val sliced = shifted.slice(0, shifted.size - 1)
      val zipped = alpha.zip(sliced)
      val builder = ListMap.newBuilder[Char, Char]
      zipped.foreach(builder.+=(_))
      val zippedMap = builder.result()
      (shift, zippedMap)
    }).toMap
  }

  def shift(n: Int): Map[Char, Char] = shiftedM.get(n % 26).get
}
