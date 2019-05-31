package negocios.controladores;

import negocios.entidades.*;
import negocios.excecoes.*;
import java.util.ArrayList;
import dados.*;

public class ControladorProfessor {

    private IRepositorioProfessor rep;

    public ControladorProfessor() {
        this.rep = new RepositorioProfessor();
    }

    public IRepositorioProfessor getRep() {
        return this.rep;
    }

    public void setRep(IRepositorioProfessor rep) {
        this.rep = rep;
    }

    public Professor logarProfessor(String login, String senha) throws UsuarioNaoCadastradoException, SenhaInvalidaException {
        return this.rep.logarProfessor(login, senha);
    }

    public boolean cadastrarProfessor(Professor professor) throws UsuarioJaCadastradoException {
        return this.rep.cadastrarProfessor(professor);
    }

    public ArrayList<Turma> exibirTurmasProfessor(int professorId) throws SemTurmaCadastradaException {
        return this.rep.exibirTurmasProfessor(professorId);
    }

    public ArrayList<RendimentoEscolar> exibirNotasProfessor(int turmaId) throws SemAlunoMatriculadoException {
        return this.rep.exibirNotasProfessor(turmaId);
    }

    public boolean atualizarNotasProfessor(int turmaId, int alunoId, float nota1, float nota2) throws NotaInvalidaException {
        return this.rep.atualizarNotasProfessor(turmaId, alunoId, nota1, nota2);
    }

    public boolean atualizarNotasTrabalhosProfessor(int turmaId, int alunoId, float[] notaTrabalhos) throws NotaInvalidaException {
        return this.rep.atualizarNotasTrabalhosProfessor(turmaId, alunoId, notaTrabalhos);
    }

    public ArrayList<Turma> exibirListagemTurmasDisponiveisProfessor(int professorId) throws SemTurmaCadastradaException {
        return this.rep.exibirListagemTurmasDisponiveisProfessor(professorId);
    }

    public boolean associarTurmaProfessor(Professor professor,int turmaId) {
        return this.rep.associarTurmaProfessor(professor, turmaId);
    }

}
