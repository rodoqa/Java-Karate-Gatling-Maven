package performance

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class perftest extends Simulation {

  val protocol = karateProtocol(

  )

  //protocol.nameResolver = (req, ctx) => req.getHeader("karate-name")

  val create = scenario("create").exec(karateFeature("classpath:examples/users/users.feature"))

  setUp(
    create.inject(rampUsers(2) during (5 seconds)).protocols(protocol)
  )

}