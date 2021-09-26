package br.uepg.entities

import javax.persistence.*

@Entity
@Table(name = "pessoas")
class Pessoa constructor() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(name = "nome")
    lateinit var nome: String

    @Column(name = "cpf")
    lateinit var cpf: String

    @Column(name = "endereco")
    var endereco: String? = null

    constructor(nome: String, cpf: String, endereco: String? = null): this() {
        this.nome = nome
        this.cpf = cpf
        this.endereco = endereco
    }

    override fun toString(): String {
        return "Pessoa(nome = $nome, cpf = $cpf, endereco = $endereco)"
    }
}