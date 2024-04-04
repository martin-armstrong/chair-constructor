# Exercise 3 - Chair Constructor

This exercise shows you a basic scala project for constructing chairs with particular 
characteristics, there are some tests you will find in test/scala/workshop that should 
pass but the code required is incomplete, follow the instructions below to complete 
the project with suitable **enums**, **case classes** and **anonymous classes** with **generic types** 
that import from different **packages** and throwing appropriate **exceptions**...

Have a look at the structure of this project, you will find packages under 
src/main/scala for chairbuilder, partbuilder and workshop.

In the ***partbuilder*** package, create the following three ***enums***...
  - Material: can be Wood, Metal or Plastic
  - Shape: can be Round, Square, Oval
  - Colour: can be Red, Blue or Pink 

Each one should also set its lowercase String **name**, e.g. Wood would be "wood".

Add a lookup method on each enum to obtain the corresponding instance by 
its String name, e.g. forName(name:String):Material where passing in "metal" 
would return you the instance for Metal.

If an invalid string is given, throw an InvalidArgumentException with a message of the 
form "No ENUM for name: VALUE" for example "No Material for name: foam"

In the same package, create classes extending the trait ***Part*** to represent 
different parts of a chair as follows...
  - Leg (has a material)
  - Seat (has a material and a shape)
  - Back (has a materiel, shape and a colour)
  
In the ***chairbuilder*** package create a case class representing a chair with 
legs, a seat and a back.
(Here one instance of Leg is assumed to represent the specification for all four)

Override the description method in Chair to summarise the construction of the chair 
using the form...

"legs:MATERIAL seat:MATERIAL,SHAPE back:MATERIAL,SHAPE,COLOUR"

for example..

"legs:wood seat:metal,round back:plastic,square,red"

***Complete Workshop.getLegBuilder, Workshop.getSeatBuilder and Workshop.getBackBuilder*** to return a anonymous classes that implement 
the appropriate partbuilder.Builder.
The build method in your implementations should return the correctly constructed part 
class corresponding to the strings passed in.

***Complete Workshop.getChairBuilder*** to return an anonymous class that implements 
chairbuilder.Builder that accepts your types Leg, Seat and Back.

The buildChair method in your implementation should return a correctly constructed 
instance of your chair case class, but only if...
- Legs are made of wood
- Seat and a Back are made of plastic
- Seat is oval
- Back is round and blue

Note the name Builder is already used in partbuilder.Builder, how can you import to 
both names without a clash?


***create and throw an InsufficientParts exception*** if a chair cannot be constructed, 
with a message describing the missing parts.
If a part has incorrect material the message should be of the form "PART is not MATERIAL" e.g. "seat is not plastic" or "back is not blue"

If all is completed the tests in test/scala/workshop/WorkshopSpec should pass.

You can run this from command line with the command **sbt test**, or in Intellij 
right click WorkshopSpec and select **"Run 'WorkshopSpec'"** 



