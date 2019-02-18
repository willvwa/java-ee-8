package controller;

import model.Pessoa;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class PessoaController implements Serializable {

    private List<Pessoa> pessoas;

    private static int contador;

    private String nome;

    private String cpf;

    @PostConstruct
    private void init() {

        this.pessoas = new ArrayList<Pessoa>();

        contador = 0;
    }

    public void novaPessoa() {

        Pessoa pessoa = new Pessoa();

        pessoa.setNome(this.nome);

        pessoa.setCpf(this.cpf);

        pessoa.setId(contador++);

        pessoas.add(pessoa);
    }

    public void limpar() {

        this.nome = "";

        this.cpf = "";
    }

    public List<Pessoa> getPessoas() {

        return this.pessoas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
