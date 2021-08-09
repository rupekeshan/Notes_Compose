package com.example.notes.domain

data class Notes(
    val id: Int,
    val header: String,
    val body: String
){
    constructor(header: String, body: String):this(id=0,header,body)
}