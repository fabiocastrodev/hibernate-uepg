package br.uepg.controllers.dtos

data class PessoaRequest(val nome: String, val cpf: String, val endereco: String? = null, val id: Long? = null)
