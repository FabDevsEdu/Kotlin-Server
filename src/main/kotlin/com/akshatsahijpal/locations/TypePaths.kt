package com.akshatsahijpal.locations

import io.ktor.locations.*

@Location("/type/{typeName}")
data class Type(val typeName: String) {
    @Location("/edit/{editor}")
    data class Edit(val editor:String)
    @Location("/locat/{locator}")
    data class Locator(val locator:String)
}