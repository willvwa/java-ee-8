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
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
    }

    public List<Pessoa> consultar() {
        return em.createQuery("SELECT P FROM Pessoa P", Pessoa.class).getResultList();
    }

    @Transactional
    public void remover(Pessoa p){
        //p = em.merge(p);
        p = em.find(Pessoa.class, p.getId());
        em.remove(p);
    }
}
