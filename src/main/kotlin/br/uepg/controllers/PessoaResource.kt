package br.uepg.controllers

import br.uepg.controllers.dtos.PessoaRequest
import br.uepg.controllers.dtos.PessoaResponse
import br.uepg.entities.Pessoa
import br.uepg.services.PessoaService
import kotlinx.coroutines.runBlocking
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/api/pessoas")
class PessoaResource(pessoaService: PessoaService) {
    private var pessoaService: PessoaService = pessoaService

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun create(body: PessoaRequest): PessoaResponse {
        var pessoa = Pessoa(nome = body.nome, cpf = body.cpf, endereco = body.endereco)

        pessoaService.save(pessoa)

        return PessoaResponse(
            id = pessoa.id,
            nome = pessoa.nome,
            cpf = pessoa.cpf,
            endereco = pessoa.endereco
        )
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun update(body: PessoaRequest): PessoaResponse {
        if (body.id == null) {
            throw Exception("Id não informado")
        }

        var pessoa = pessoaService.findById(body.id)

        pessoaService.save(pessoa.apply {
            nome = body.nome
            cpf = body.cpf
            endereco = body.endereco
        })

        return PessoaResponse(
            id = pessoa.id,
            nome = pessoa.nome,
            cpf = pessoa.cpf,
            endereco = pessoa.endereco
        )
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun findById(@PathParam("id") id: Long): PessoaResponse {
        var pessoa = pessoaService.findById(id)

        return PessoaResponse(
            id = pessoa.id,
            nome = pessoa.nome,
            cpf = pessoa.cpf,
            endereco = pessoa.endereco
        )
    }
}