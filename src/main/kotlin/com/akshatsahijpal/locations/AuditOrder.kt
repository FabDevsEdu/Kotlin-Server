package com.akshatsahijpal.locations

import io.ktor.locations.*

@Location("/order/{orderName}/{orderId}")
data class AuditOrder(val orderName: String, var orderId: Int)

