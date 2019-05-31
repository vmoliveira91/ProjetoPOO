package negocios.entidades;

import java.util.ArrayList;

public class Turma {

    private int id;
    private Disciplina disciplina;
    private Professor professor;
    private int capacidadeDaTurma;
    private ArrayList<Aluno> alunos;

    public Turma(int id, Disciplina disciplina, Professor professor, int capacidadeDaTurma, ArrayList<Aluno> alunos) {
        this.id = id;
        this.disciplina = disciplina;
        this.professor = professor;
        this.capacidadeDaTurma = capacidadeDaTurma;
        this.alunos = alunos;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getCapacidadaDaTurma() {
        return this.capacidadeDaTurma;
    }

    public void setCapacidadeDaTurma(int capacidadeDaTurma) {
        this.capacidadeDaTurma = capacidadeDaTurma;
    }

    public ArrayList<Aluno> getAlunos() {
        return this.alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    @Override
    public String toString() {
        return this.id + " - " + this.disciplina.getNome();
    }
}
