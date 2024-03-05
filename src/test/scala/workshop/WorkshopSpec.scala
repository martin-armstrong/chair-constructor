package workshop

import chairbuilder.{Chair, InsufficientPartsException}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class WorkshopSpec extends AnyWordSpec with Matchers {

  "Workshop" should {
    "build a chair" in {
      val leg = Workshop.getPartBuilder.buildPart("leg", "wood", "", "")
      val seat = Workshop.getPartBuilder.buildPart("seat", "plastic", "round", "")
      val back = Workshop.getPartBuilder.buildPart("back", "plastic", "oval", "blue")

      val chair:Chair = Workshop.getChairBuilder.buildChair(leg, leg, leg, leg, seat, back)
      chair.description shouldBe "legs:wood seat:plastic,round back:plastic,oval,blue"
    }

    "fail to build a chair with metal seat" in {
      val leg = Workshop.getPartBuilder.buildPart("leg", "wood", "", "")
      val seat = Workshop.getPartBuilder.buildPart("seat", "metal", "round", "")
      val back = Workshop.getPartBuilder.buildPart("back", "plastic", "oval", "blue")

      try {
        Workshop.getChairBuilder.buildChair(leg, leg, leg, leg, seat, back)
        fail("should fail with InsufficientParts exception describing the error")
      } catch {
        case ex:InsufficientPartsException => ex.getMessage shouldBe "seat not made of wood"
      }
    }

    "fail to build a chair with a pink back" in {
      val leg = Workshop.getPartBuilder.buildPart("leg", "wood", "", "")
      val seat = Workshop.getPartBuilder.buildPart("seat", "plastic", "round", "")
      val back = Workshop.getPartBuilder.buildPart("back", "plastic", "oval", "pink")

      try {
        Workshop.getChairBuilder.buildChair(leg, leg, leg, leg, seat, back)
        fail("should fail with InsufficientParts exception describing the error")
      } catch {
        case ex:InsufficientPartsException => ex.getMessage shouldBe "back is not blue"
      }
    }
  }

}
