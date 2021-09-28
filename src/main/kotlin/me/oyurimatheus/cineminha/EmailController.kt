package me.oyurimatheus.cineminha

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import me.oyurimatheus.cineminha.ingressos.EmailRequest

@Controller("/api/email")
class EmailController {
    
    @Post
    fun recebido(email: String) {
        println(email)
    }
}