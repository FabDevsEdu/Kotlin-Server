package com.akshatsahijpal.routes

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.getRoot(){
    route("/", HttpMethod.Get) {
        handle {
            call.respondText("Root Page")
        }
    }
}