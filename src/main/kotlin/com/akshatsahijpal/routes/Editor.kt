package com.akshatsahijpal.routes

import com.akshatsahijpal.locations.Type
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.routing.get

fun Route.getTypeRoutes() {
   get <Type.Edit>{ Edit ->
       call.respondText ("for Type.Edit = ${Edit.editor}")
   }

    get <Type.Locator>{ loc ->
        call.respondText ("for Type.Locator = ${loc.locator}")
    }

}