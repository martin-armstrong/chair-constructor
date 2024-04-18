package workshop

import partbuilder.{Back, Builder, Colour, Leg, Material, Seat, Shape}
import chairbuilder.{Chair, InsufficientPartsException, MyChair, Builder => ChairBuilder}

object Workshop {


  /*
 * return an anonymous class that implements a Leg Builder with appropriate return type
 */
  def getLegBuilder:Builder[Leg] = new Builder[Leg] {
    override def build(material: String, shape: String, colour: String): Leg = Leg(Material.forName(material))
  }

  /*
* return an anonymous class that implements a Seat Builder with appropriate return type
*/
  def getSeatBuilder:Builder[Seat] = new Builder[Seat] {
    override def build(material: String, shape: String, colour: String): Seat = Seat(Material.forName(material), Shape.forName(shape))
  }

  /*
* return an anonymous class that implements a Back Builder with appropriate return type
*/
  def getBackBuilder:Builder[Back] = new Builder[Back] {
    override def build(material: String, shape: String, colour: String): Back = Back(Material.forName(material), Shape.forName(shape), Colour.forName(colour))
  }

 /**
  *
  * add the correct return type and return an anonymous class that implements chair Builder
  *
  * This chair builder should only work with correct parts which are....
    Legs are made of wood
    Seat and a Back are made of plastic
    Seat is oval
    Back is round and blue
  *
  */
 def getChairBuilder: ChairBuilder[Leg, Seat, Back] = new ChairBuilder[Leg, Seat, Back] {
   override def buildChair(legs: Leg, seat: Seat, back: Back): Chair = {
     if(legs.material != Material.Wood) {
       throw new InsufficientPartsException("legs is not wood")
     }

     if(seat.material != Material.Plastic) {
       throw new InsufficientPartsException("seat is not plastic")
     }

     if(back.material != Material.Plastic) {
       throw new InsufficientPartsException("back is not plastic")
     }

     if(seat.shape != Shape.Oval) {
       throw new InsufficientPartsException("seat is not oval")
     }

     if(back.shape != Shape.Round) {
       throw new InsufficientPartsException("back is not round")
     }

     if(back.colour != Colour.Blue) {
       throw new InsufficientPartsException("back is not blue")
     }

     MyChair(legs, seat, back)
   }
 }

}
