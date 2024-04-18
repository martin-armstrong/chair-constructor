package chairbuilder

import partbuilder.{Back, Leg, Seat}

case class MyChair(legs:Leg, seat:Seat, back:Back) extends Chair {
  override def description: String = s"legs:${legs.material.name} seat:${seat.material.name},${seat.shape.name} back:${back.material.name},${back.shape.name},${back.colour.name}"
}
