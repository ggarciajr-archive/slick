package code.model

import scala.slick.driver.H2Driver.simple._
import Database.threadLocalSession
import slick.session.Database

/**
 * User: ggarcia
 * Date: 3/27/13
 * Time: 6:16 PM
 */

case class Coffee(name: String, supId: Int, price: Double)

object Coffees extends Table[Coffee]("coffees") {
  val conn = Database.forURL("jdbc:h2:mem:test1", driver = "org.h2.Driver")

  def name = column[String]("cof_name", O.PrimaryKey)
  def supID = column[Int]("sup_id")
  def price = column[Double]("price")

  def * = name ~ supID ~ price <>(Coffee, Coffee.unapply _)

  def listAll = conn withSession {
    createAll()
    Query(Coffees).list()
  }

  def createAll() {
    (Coffees.ddl).create

    Coffees.insertAll(
      Coffee("Colombian", 101, 7.99),
      Coffee("Colombian_Decaf", 101, 8.99),
      Coffee("French_Roast_Decaf", 49, 9.99)
    )
  }
}