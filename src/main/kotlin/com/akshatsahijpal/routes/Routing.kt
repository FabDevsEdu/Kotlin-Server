package com.akshatsahijpal.routes

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*

fun Application.configureRouting() {
    routing {
        getRoot()
        getEtcName()
        getTxParam()
    }
}

