package me.oyurimatheus.cineminha.filmes

import me.oyurimatheus.cineminha.ingressos.Ingresso
import java.math.BigDecimal
import java.time.LocalTime
import java.util.*
import javax.persistence.*

@Entity
class Sessao(val horario: LocalTime,
             @field:ManyToOne val sala: Sala,
             @field:ManyToOne val filme: Filme,
             val preco: BigDecimal) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @OneToMany(mappedBy = "sessao", cascade = [ CascadeType.MERGE ])
    val ingressos: List<Ingresso> = Collections.emptyList()
}