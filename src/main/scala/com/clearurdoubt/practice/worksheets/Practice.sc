
implicit def doubleToInt(n: Double): Int = n.toInt

val x: Int = 2.3   // implicit conversion happens from Double to Int


val strings = List("hello world", "great world", "Scala", "Rocking Scala!")

val str = strings.find(x => x.contains("Scala"))

println(str.getOrElse("found nothing in the strings"))

val (evens, odds) = List(1, 2, 3, 4).partition(_ % 2 == 0)

println("evens: " + evens)

def factorial(n: Int): BigInt =
  if(n <= 0) 1
  else
    n * factorial(n - 1)

val fact = factorial(5000)

val languages = Seq("Scala", "Haskell", "Java")

// Partial Functions
val default: PartialFunction[Int, String] = {
    case _ => "Is it a programming Language?"
}

val languagesWithDefault = languages orElse default
println(languages(4) orElse default)