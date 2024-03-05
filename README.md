# Exercise 3 - Chair Constructor

This exercise shows you a basic scala project for constructing chairs with particular characteristics, there are some tests you will find in test/scala/workshop that should pass but the code required is incomplete, follow the instructions below to complete the project with suitable enums, case classes and anonymous classes...

Have a look at the structure of this project, you will find packages under src/main/scala for chairbuilder, partbuilder and workshop.

In the ***partbuilder*** package, create the following three ***enums***...
  - Material: can be wood, metal or plastic
  - Shape: can be round, square, oval
  - Colour: can be red, blue or pink

In the same package, create classes extending the trait ***Part*** to represent different parts of a chair as follows...
  - Leg (has a material)
  - Seat (has a material and a shape)
  - Back (has a materiel, shape and a colour)
  
In the ***chairbuilder*** package create a case class representing a chair with 6 Parts - 4 Legs, a Seat and a Back.
override the description method in Chair to summarise the construction of the chair using the form...

"legs:MATERIAL seat:MATERIAL,SHAPE back:MATERIAL,SHAPE,COLOUR"

for example..

"legs:wood seat:metal,round back:plastic,square,red"

***Complete Workshop.getPartBuilder*** to return an anonymous class that implements partbuilder.Builder.
The buildPart method in your implementation should return the correctly constructed part class corresponding to the string descriptions passed in.

***Complete Workshop.getChairBuilder*** to return an anonymous class that implements chairbuilder.Builder
The buildChair method in your implementation should return a correctly constructed instance of your chair case class, but only if...
  - Legs are made of wood
  - Seat and a Back are made of plastic
  - Seat is oval
  - Back is round and blue

***create and throw an InsufficientParts exception*** if a chair cannot be constructed, with a message describing the missing parts.
If a part has incorrect material the message should be of the form "PART is not made of MATERIAL" e.g. "leg is not made of wood"

If all is completed the test/scala/workshop/WorkshopSpec should pass :)



