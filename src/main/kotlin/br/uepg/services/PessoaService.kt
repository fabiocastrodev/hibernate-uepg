package br.uepg.services

import br.uepg.entities.Pessoa
import javax.enterprise.context.ApplicationScoped
import javax.persistence.EntityManager
import javax.transaction.Transactional

@ApplicationScoped
class PessoaService(em: EntityManager) {
    private var em: EntityManager = em

    @Transactional
    fun save(pessoa: Pessoa) {
        em.merge(pessoa)
    }

    @Transactional
    fun findById(id: Long): Pessoa {
        return em.find(Pessoa::class.java, id)
    }
}