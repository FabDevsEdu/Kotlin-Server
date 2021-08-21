package com.akshatsahijpal

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.akshatsahijpal.routes.configureRouting

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        configureRouting()
    }.start(wait = true)
}