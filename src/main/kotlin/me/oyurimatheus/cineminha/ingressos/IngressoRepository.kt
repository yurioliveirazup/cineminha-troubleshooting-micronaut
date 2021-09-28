package me.oyurimatheus.cineminha.ingressos

import io.micronaut.data.repository.CrudRepository
import java.util.*

interface IngressoRepository : CrudRepository<Ingresso, UUID>