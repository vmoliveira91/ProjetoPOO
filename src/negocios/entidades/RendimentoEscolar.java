package negocios.entidades;

public class RendimentoEscolar {

    private Turma turma;
    private Aluno aluno;
    private float nota1;
    private float nota2;
    private String[] trabalhos = new String[4];
    private float[] notaTrabalhos = new float[4];

    public RendimentoEscolar(Turma turma, Aluno aluno, float nota1, float nota2, String[] trabalhos, float[] notaTrabalhos) {
        this.turma = turma;
        this.aluno = aluno;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.trabalhos = trabalhos;
        this.notaTrabalhos = notaTrabalhos;
    }

    public Turma getTurma() {
        return this.turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public float getNota1() {
        return this.nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return this.nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public String[] getTrabalhos() {
        return this.trabalhos;
    }

    public void setTrabalhos(String[] trabalhos) {
        this.trabalhos = trabalhos;
    }

    public float[] getNotaTrabalhos() {
        return this.notaTrabalhos;
    }

    public void setNotaTrabalhos(float[] notaTrabalhos) {
        this.notaTrabalhos = notaTrabalhos;
    }
}
