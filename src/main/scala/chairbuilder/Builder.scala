package chairbuilder

import partbuilder.Part

trait Builder {
  def buildChair(legA:Part, legB:Part, legC:Part, legD:Part, seat:Part, back:Part):Chair
}
