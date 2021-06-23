package me.oyurimatheus.cineminha.ingressos

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface IngressoRepository : CrudRepository<Ingresso, Long>