package partbuilder

sealed trait Shape {
  val name:String
}
object Shape {
  case object Round extends Shape {override val name = "round"}
  case object Square extends Shape  {override val name = "square"}
  case object Oval extends Shape  {override val name = "oval"}

  def forName(name:String): Shape = {
    if(name==Round.name) Round
    else if(name==Square.name) Square
    else if(name==Oval.name) Oval
    else throw new IllegalArgumentException(s"No Shape for name: $name")
  }
}

