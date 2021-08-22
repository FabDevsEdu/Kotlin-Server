package com.akshatsahijpal

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.html.body
import kotlinx.html.h1
import kotlinx.html.head
import kotlinx.html.title

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        module()
        routing {
            var name = "Root"
            get("/") {
                call.respondHtml(HttpStatusCode.OK) {
                    head {
                        title {
                            +name
                        }
                    }
                    body {
                        h1{
                           +"Root Location "
                        }
                    }
                }
            }
        }
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
