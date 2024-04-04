package chairbuilder

import partbuilder.Part

abstract class Builder[L<:Part, S<:Part, B<:Part] {
  def buildChair(legs:L, seat:S, back:B):Chair
}
