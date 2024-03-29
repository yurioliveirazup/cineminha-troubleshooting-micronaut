package me.oyurimatheus.cineminha.ingressos

import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client

@Client("/api/email")
interface EmailClient {

    @Post
    fun envia(emailRequest: EmailRequest)
}

class EmailRequest(val remetente: String,
                   val destinatario: String,
                   val corpo: String
)
