import io.vertx.kotlin.common.json.*

class start : io.vertx.core.AbstractVerticle()  {
  override fun start() {
    vertx.setPeriodic(1000, { l ->
      vertx.createHttpClient().getNow(8080, "localhost", "/", { resp ->
        resp.bodyHandler({ body ->
          println(body.toString("ISO-8859-1"))
        })
      })
    })
  }
}
