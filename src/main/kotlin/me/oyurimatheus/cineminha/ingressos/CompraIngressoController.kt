package me.oyurimatheus.cineminha.ingressos

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import me.oyurimatheus.cineminha.filmes.SessaoRepository
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Controller("/api/ingressos")
class CompraIngressoController(val sessaoRepository: SessaoRepository,
                               val ingressoRepository: IngressoRepository
) {


    @Post
    fun compra(@Body request: NovoIngressoRequest) : HttpResponse<Any> {
        val ingresso = request.paraIngresso(sessaoRepository)

        val salvo = ingressoRepository.save(ingresso)

        val uri = HttpResponse.uri("/api/ingressos/${salvo.id}")
        return HttpResponse.created(uri)
    }
}

data class NovoIngressoRequest(@field:Positive val sessaoId: Long,
                               @field:NotNull val tipo: Tipo,
                               @field:Email @field:NotBlank val email: String) {

    fun paraIngresso(sessaoRepository: SessaoRepository) : Ingresso {

        val possivelSessao = sessaoRepository.findById(sessaoId)

        if (possivelSessao.isEmpty)
            throw IllegalStateException("Sessao não cadastrada")

        return Ingresso(tipo, email, possivelSessao.get())

    }
}