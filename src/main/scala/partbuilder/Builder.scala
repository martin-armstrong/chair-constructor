package partbuilder

abstract class Builder[P <: Part] {
  def build(material:String, shape:String, colour:String): P
}