package com.akshatsahijpal.routes

import com.akshatsahijpal.locations.AuditOrder
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.orderAuditor() {
    get<AuditOrder> { AuditOrder ->
        call.respondText("Running order for Name = ${AuditOrder.orderName} and ID = ${AuditOrder.orderId}")
    }
}