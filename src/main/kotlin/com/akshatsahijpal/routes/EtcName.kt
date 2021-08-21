package com.akshatsahijpal.routes

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.getEtcName() {
    get("/etc/{name?}") {
        if (call.parameters["name"] == "akshat") {
            call.respondText("Authored by Akshat ")
        } else {
            call.respondText("Authored by NON")
        }
    }
}