package com.akshatsahijpal.routes

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.getTxParam(){
    get("/tx/{param...}") {
        val params = call.parameters.getAll("param") as List<String>
        call.respondText("Res: $params")

    }
}