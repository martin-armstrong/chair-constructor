package partbuilder

import partbuilder.Shape.{Oval, Round, Square}

sealed trait Colour {
  val name:String
}
object Colour {
  object Red extends Colour {override val name = "red"}
  object Blue extends Colour {override val name = "blue"}
  object Pink extends Colour {override val name = "pink"}

  def forName(name:String): Colour = {
    if(name==Red.name) Red
    else if(name==Blue.name) Blue
    else if(name==Pink.name) Pink
    else throw new IllegalArgumentException(s"No Colour for name: $name")
  }
}

