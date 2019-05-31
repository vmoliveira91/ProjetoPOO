package negocios.entidades;

import java.util.Date;

public class Professor {

    private int id;
    private String nome;
    private String cargo;
    private Date dataNascimento;
    private String login;
    private String senha;

    public Professor(int id, String nome, String cargo, int dia, int mes, int ano, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.dataNascimento = new Date(ano, mes, dia);
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

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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
