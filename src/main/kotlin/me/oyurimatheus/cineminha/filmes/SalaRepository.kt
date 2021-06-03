package me.oyurimatheus.cineminha.filmes

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface SalaRepository : CrudRepository<Sala, Long>