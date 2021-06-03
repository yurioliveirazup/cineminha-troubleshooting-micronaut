package me.oyurimatheus.cineminha.filmes

import java.time.Duration
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id

@Entity
class Filme(val nome: String,
            val duracao: Duration) {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null
}