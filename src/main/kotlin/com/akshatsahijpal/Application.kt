package com.akshatsahijpal

import com.akshatsahijpal.routes.rootRouter
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        module()
        rootRouter()
    }.start(wait = true)
}

fun Application.module() {
    install(StatusPages) {
        exception<NotFoundException> { cause ->
            // call.respond(HttpStatusCode.NotFound)
            call.respondRedirect("/error", permanent = true)
            //    throw cause
        }
        exception<Throwable> { cause ->
            call.respond(HttpStatusCode.InternalServerError)
            throw cause
        }
    }
}
