package negocios.entidades;

import java.time.LocalDate;

public class Aluno {

    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private int periodo;
    private String login;
    private String senha;

    public Aluno(int id, String nome, int dia, int mes, int ano, int periodo, String login, String senha) {
        this.id = id;
        this.nome = nome;
        if(ano != 0)
            this.dataNascimento = LocalDate.of(ano, mes, dia);
        else
            this.dataNascimento = null;
        this.periodo = periodo;
        this.login = login;
        this.senha = senha;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
