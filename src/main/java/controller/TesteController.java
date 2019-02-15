package controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class TesteController implements Serializable {

    private String mensagemBoasVindas;

    private String nome;

    @PostConstruct
    private void init() {

        this.mensagemBoasVindas = "Hello world!";
    }

    public void teste() {

        this.mensagemBoasVindas = this.nome;
    }

    public String getMensagemBoasVindas() {
        return mensagemBoasVindas;
    }

    public void setMensagemBoasVindas(String mensagemBoasVindas) {
        this.mensagemBoasVindas = mensagemBoasVindas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
