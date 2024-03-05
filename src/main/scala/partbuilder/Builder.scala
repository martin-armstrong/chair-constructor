package partbuilder

trait Builder {
  def buildPart(name:String,material:String, shape:String, colour:String): Part
}