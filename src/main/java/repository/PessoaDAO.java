package repository;

import model.Pessoa;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class PessoaDAO implements Serializable {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void salvar(Pessoa pessoa) {
        em.persist(pessoa);
    }

    public List<Pessoa> consultar() {
        return em.createQuery("SELECT P FROM Pessoa P", Pessoa.class).getResultList();
    }

    public void remover(Pessoa pessoa) {

        em.remove(pessoa);
    }
}
