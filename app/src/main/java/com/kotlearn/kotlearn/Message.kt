package com.kotlearn.kotlearn

class Message {

    constructor()

    constructor(messageText: String){
        text = messageText
    }
    var user: String? = null
    var text: String? = null
    var timestamp: Long = System.currentTimeMillis()
}