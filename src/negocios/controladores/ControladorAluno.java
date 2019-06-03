package negocios.controladores;

import negocios.entidades.*;
import negocios.excecoes.*;
import java.util.ArrayList;
import dados.*;

public class ControladorAluno {

    private IRepositorioAluno rep;

    public ControladorAluno() {
        this.rep = new RepositorioAluno();
    }

    public IRepositorioAluno getRep() {
        return this.rep;
    }

    public void setRep(IRepositorioAluno rep) {
        this.rep = rep;
    }

    public Aluno logarAluno(String login, String senha) throws UsuarioNaoCadastradoException, SenhaInvalidaException {
        return this.rep.logarAluno(login, senha);
    }

    public boolean cadastrarAluno(Aluno aluno) throws UsuarioJaCadastradoException {
        return this.rep.cadastrarAluno(aluno);
    }

    public ArrayList<Turma> exibirTurmasAluno(int alunoId) throws SemTurmaCadastradaException {
        return this.rep.exibirTurmasAluno(alunoId);
    }

    public RendimentoEscolar exibirNotasAluno(int turmaId, int alunoId) {
        return this.rep.exibirNotasAluno(turmaId, alunoId);
    }

    public boolean adicionarTrabalho(int turmaId, int alunoId, String[] trabalhoNovo) {
        return this.rep.adicionarTrabalho(turmaId, alunoId, trabalhoNovo);
    }

    public ArrayList<Turma> exibirListagemTurmasDisponiveisAluno(int alunoId) throws SemTurmaCadastradaException {
        return this.rep.exibirListagemTurmasDisponiveisAluno(alunoId);
    }

    public boolean associarTurmaAluno(Aluno aluno, int turmaId) {
        return this.rep.associarTurmaAluno(aluno, turmaId);
    }
}
