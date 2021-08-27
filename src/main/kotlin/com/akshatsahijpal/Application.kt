package com.akshatsahijpal

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        module()
    }.start(wait = true)
}

@Serializable
data class Customer(val id: Int, val firstName: String, val lastName: String)


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
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
        })
    }
}
