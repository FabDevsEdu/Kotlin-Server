package com.akshatsahijpal

import com.akshatsahijpal.locations.AuditOrder
import com.akshatsahijpal.routes.configureRouting
import io.ktor.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        module()
        configureRouting()
    }.start(wait = true)
}
fun Application.module() {
    install(Locations) {}
}
