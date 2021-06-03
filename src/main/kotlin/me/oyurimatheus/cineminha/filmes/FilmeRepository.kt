package me.oyurimatheus.cineminha.filmes

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface FilmeRepository : CrudRepository<Filme, Long>