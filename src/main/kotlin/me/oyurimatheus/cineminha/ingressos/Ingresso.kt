package me.oyurimatheus.cineminha.ingressos

import me.oyurimatheus.cineminha.filmes.Sessao
import java.math.BigDecimal
import java.math.RoundingMode
import javax.persistence.*
import javax.validation.constraints.Email

class Ingresso(@field:Enumerated val tipo: Tipo,
               @field:Email val email: String,
               val sessao: Sessao
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    val preco = tipo.calcula(sessao.preco)

}

enum class Tipo {
    INTEIRA {

        override fun calcula(preco: BigDecimal): BigDecimal {
            return preco
        }

    },
    MEIA_ENTRADA {

        override fun calcula(preco: BigDecimal): BigDecimal {
            return preco.div(BigDecimal("2.0"))
        }

    };

    abstract fun calcula(preco: BigDecimal): BigDecimal
}
