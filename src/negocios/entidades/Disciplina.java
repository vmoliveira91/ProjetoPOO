package negocios.entidades;

public class Disciplina {

    private int id;
    private String nome;
    private String ementa;

    public Disciplina(int id, String nome, String ementa) {
        this.id = id;
        this.nome = nome;
        this.ementa = ementa;
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

    public String getEmenta() {
        return this.ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }
}
