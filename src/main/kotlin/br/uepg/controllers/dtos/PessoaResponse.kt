package br.uepg.controllers.dtos

data class PessoaResponse(val id: Long, val nome: String, val cpf: String, val endereco: String? = null)
