package code
package snippet

import model.Coffees
import net.liftweb.util.BindHelpers._

class HelloWorld {
  def list = "*" #> {
    val coffees = Coffees.listAll
    coffees.map(c => "span *" #> c.name)
  }
}

