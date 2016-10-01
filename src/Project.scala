
import java.io._

object Project {
  def main(args:Array[String]): Unit = {
    val current = scala.io.Source.fromFile("file.txt")
      .getLines
      .flatMap(_.split("\\W+"))
      .foldLeft(Map.empty[String, Int]) {
        (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
      }

    val pw = new PrintWriter(new File("result.txt" ))
    current.toSeq.sortBy(_._1).foreach{
      case (key, value) => val output = key + " = " + value
        pw.println(output)
    }
    pw.close


  }
}