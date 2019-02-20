package controller;

import model.Pessoa;
import repository.PessoaDAO;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class PessoaController implements Serializable {

    @Inject
    private PessoaDAO pessoaDAO;

    private Pessoa pessoaForm;

    private List<Pessoa> pessoas;

    private Pessoa pessoaSelecionada;

    @PostConstruct
    private void innit (){
        pessoaForm = new Pessoa();
        atualizarTabela();
    }

    public void cadastrar(){

        pessoaDAO.salvar(pessoaForm);
        limpar();
        atualizarTabela();
    }

    public void limpar(){
        this.pessoaForm = new Pessoa();
    }

    public void atualizarTabela() {
        this.pessoas = pessoaDAO.consultar();
    }

    public void excluir(){
        pessoaDAO.remover(pessoaSelecionada);
        limpar();
        atualizarTabela();
    }

    public void aoSelecionar(){
        this.pessoaForm = pessoaSelecionada;
    }

    public void aoDesselecionar(){
        limpar();
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Pessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }

    public Pessoa getPessoaForm() {
        return pessoaForm;
    }

    public void setPessoaForm(Pessoa pessoaForm) {
        this.pessoaForm = pessoaForm;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }
}
