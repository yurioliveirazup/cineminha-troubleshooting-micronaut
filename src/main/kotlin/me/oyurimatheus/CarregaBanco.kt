package me.oyurimatheus

import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.runtime.event.ApplicationStartupEvent
import me.oyurimatheus.cineminha.filmes.FilmeRepository
import me.oyurimatheus.cineminha.filmes.SalaRepository
import me.oyurimatheus.cineminha.filmes.SessaoRepository
import java.math.BigDecimal

import me.oyurimatheus.cineminha.filmes.Sessao

import me.oyurimatheus.cineminha.filmes.Sala


import me.oyurimatheus.cineminha.filmes.Filme
import java.time.Duration
import java.time.LocalTime.now
import java.time.temporal.ChronoUnit
import java.time.temporal.ChronoUnit.HOURS
import javax.inject.Singleton


@Singleton
class CarregaBanco(val sessaoRepository: SessaoRepository,
                   val filmeRepository: FilmeRepository,
                   val salaRepository: SalaRepository
): ApplicationEventListener<ApplicationStartupEvent> {


    override fun onApplicationEvent(event: ApplicationStartupEvent?) {

        val homemAranha = Filme("Homem Aranha", Duration.of(1, HOURS))
        val harryPotter = Filme("Harry Potter", Duration.of(1, HOURS))
        val procurandoNemo = Filme("Procurando Nemo", Duration.of(1, HOURS))

        val paris = Sala("Paris")
        val roma = Sala("Roma")
        val londres = Sala("Londres")

        val sessaoHomemAranha = Sessao(now().plusHours(24), paris, homemAranha, BigDecimal("30.0"))
        val sessaoHarryPotter = Sessao(now().plusHours(24), roma, harryPotter, BigDecimal("20.0"))
        val sessaoProcurandoNemo = Sessao(now().plusHours(24), londres, procurandoNemo, BigDecimal("50.0"))

        filmeRepository.save(homemAranha)
        filmeRepository.save(harryPotter)
        filmeRepository.save(procurandoNemo)

        salaRepository.save(paris)
        salaRepository.save(roma)
        salaRepository.save(londres)

        sessaoRepository.save(sessaoHomemAranha)
        sessaoRepository.save(sessaoHarryPotter)
        sessaoRepository.save(sessaoProcurandoNemo)
    }
}