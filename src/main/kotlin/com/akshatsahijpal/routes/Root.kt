package com.akshatsahijpal.routes

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Routing.root() {
    get("/") {
        var appReq: ApplicationRequest = call.request
        call.respondText("URI :${appReq.uri}")
    }
    get("/stu") {
        var appReq: ApplicationRequest = call.request
        var uri = appReq.uri
        // url: /stu?marks='asc'
       when(appReq.queryParameters["marks"]){
            "asc" -> call.respondText("For $uri asc : Ascending Order ")
            "dsc" -> call.respondText("For $uri asc : Descending Order ")
        }
    }
    get("/products") {
        if (call.request.queryParameters["price"] == "asc") {
            call.respondText("URI :${call.request.uri}")   }
    }
    // /loc?city=""
    get("/loc"){
        var appReq: ApplicationRequest = call.request
        var city = appReq.queryParameters["city"]!!
        call.respondText("City Result : $city Noting Valuable found ")
    }

}