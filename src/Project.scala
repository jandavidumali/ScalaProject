import java.io._

object Project {
  def main(args:Array[String]): Unit = {
    val pw = new PrintWriter(new File("result.txt"))
    val file = scala.io.Source.fromFile("file.txt").getLines().toList
      .flatMap(_.split(" ")).filter(x => x.matches("[a-zA-Z]+")).sorted.groupBy(x => x)
      .map(y => (y._1, y._2.length))
      .toList.sorted

    for(c <- file) {
      pw.write(c._1 + " = " + c._2 + "\r\n")
    }
    pw.close()
  }
}