package me.oyurimatheus.cineminha.ingressos

import io.micronaut.data.repository.CrudRepository

interface IngressoRepository : CrudRepository<Ingresso, Long>