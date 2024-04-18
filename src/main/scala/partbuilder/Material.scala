package partbuilder

sealed trait Material {
  val name:String
}
object Material {
  case object Wood extends Material{override val name = "wood"}
  case object Metal extends Material{override val name = "metal"}
  case object Plastic extends Material{override val name = "plastic"}

  def forName(name:String): Material = {
    if(name==Wood.name) Wood
    else if(name==Metal.name) Metal
    else if(name==Plastic.name) Plastic
    else throw new IllegalArgumentException(s"No Material for name: $name")
  }
}
