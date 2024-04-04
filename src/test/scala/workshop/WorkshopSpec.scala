package workshop

import chairbuilder.{Chair, InsufficientPartsException}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class WorkshopSpec extends AnyWordSpec with Matchers {

  "Workshop" should {
    "build a chair" in {
      val legs = Workshop.getLegBuilder.build("wood", "", "")
      val seat = Workshop.getSeatBuilder.build("plastic", "oval", "")
      val back = Workshop.getBackBuilder.build("plastic", "round", "blue")

      val chair:Chair = Workshop.getChairBuilder.buildChair(legs, seat, back)
      chair.description shouldBe "legs:wood seat:plastic,oval back:plastic,round,blue"
    }

    "fail to build a leg with invalid material" in {
      try {
        val legs = Workshop.getLegBuilder.build("jelly", "", "")
        fail("should fail with InvalidArgumentException exception with message 'No Material for name: jelly'")
      } catch {
        case ex:IllegalArgumentException => ex.getMessage shouldBe "No Material for name: jelly"
      }
    }

    "fail to build a chair with incorrect seat material" in {
      val legs = Workshop.getLegBuilder.build("wood", "", "")
      val seat = Workshop.getSeatBuilder.build("metal", "oval", "")
      val back = Workshop.getBackBuilder.build("plastic", "round", "blue")

      try {
        Workshop.getChairBuilder.buildChair(legs, seat, back)
        fail("should fail with InsufficientParts exception with message 'seat is not plastic'")
      } catch {
        case ex:InsufficientPartsException => ex.getMessage shouldBe "seat is not plastic"
      }
    }

    "fail to build a chair with incorrect back colour" in {
      val legs = Workshop.getLegBuilder.build("wood", "", "")
      val seat = Workshop.getSeatBuilder.build("plastic", "oval", "")
      val back = Workshop.getBackBuilder.build("plastic", "round", "pink")

      try {
        Workshop.getChairBuilder.buildChair(legs, seat, back)
        fail("should fail with InsufficientParts exception describing the error")
      } catch {
        case ex:InsufficientPartsException => ex.getMessage shouldBe "back is not blue"
      }
    }
  }

}
