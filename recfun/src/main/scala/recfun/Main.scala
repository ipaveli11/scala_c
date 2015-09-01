package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
      
    }
    println("Parentheses Balancing")
        println(balance("just test( dddd)(d)(d)example".toList));

    //println("Counting Change")
    //    print(countChange("just test( dddd)(d)(d)example".toList));
  }

  /**
   * Exercise 1
   */
  //@tailrec
  def pascal(c: Int, r: Int) :  Int = {

        if (c == 0 || c == r)
          1
        else
            pascal (c, r - 1) + pascal(c - 1, r - 1);
 
  }


  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def p_b(chars: List[Char], p: Int): Boolean = {
      if (chars.isEmpty){
        true
      }
      else {
          val h = chars.head
          val n = 
          if (h == '(')
            p + 1
          else if (h == ')')
            p - 1
          else
            p  
          if (n >= 0) p_b(chars.tail, n)
          else false
        }
    }
    p_b(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    
    def f(lastMaxCoin_total_coll: List[(Int, Int)], count: Int): Int = {
      if (lastMaxCoin_total_coll.isEmpty) {
        count
      } 
      else {
        val b = ListBuffer[(Int, Int)]()
        var newCount = count
        for ((lastMaxCoin, total) <- lastMaxCoin_total_coll) {
        if (total < money) {
          for (c <- coins) {
            if (c >= lastMaxCoin) {
              val e = (c, total + c)
              b += e
            }
          }
        } else if (total == money) {
          newCount += 1
          }
        }
        f(b.toList, newCount)
      }
    }
    
    val b = coins.map { c => (c, c) }
    f(b, 0)
  }

}
