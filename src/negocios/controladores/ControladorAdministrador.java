package negocios.controladores;

import negocios.entidades.*;
import negocios.excecoes.*;
import java.util.ArrayList;
import dados.*;

public class ControladorAdministrador {

    private IRepositorioAdministrador rep;

    public ControladorAdministrador() {
        this.rep = new RepositorioAdministrador();
    }

    public IRepositorioAdministrador getRep() {
        return this.rep;
    }

    public void setRep(IRepositorioAdministrador rep) {
        this.rep = rep;
    }
    
    public boolean logarAdministrador(String login, String senha) throws UsuarioNaoCadastradoException, SenhaInvalidaException {
        return this.rep.logarAdministrador(login, senha);
    }
    
    public boolean cadastrarDisciplina(Disciplina disciplina) {
        return this.rep.cadastrarDisciplina(disciplina);
    }

    public boolean removerDisciplina(int disciplinaId) {
        return this.rep.removerDisciplina(disciplinaId);
    }

    public ArrayList<Disciplina> listarDisciplinas() throws SemDisciplinaCadastradaException {
        return this.rep.listarDisciplinas();
    }

    public boolean cadastrarTurma(Turma turma) throws CapacidadeInvalidaException {
        return this.rep.cadastrarTurma(turma);
    }

    public boolean removerTurma(int turmaId) throws SemTurmaCadastradaException {
        return this.rep.removerTurma(turmaId);
    }

    public ArrayList<Turma> listarTurmas() throws SemTurmaCadastradaException {
        return this.rep.listarTurmas();
    }

    public boolean removerProfessor(int professorId) {
        return this.rep.removerProfessor(professorId);
    }

    public ArrayList<Professor> listarProfessores() throws UsuarioNaoCadastradoException {
        return this.rep.listarProfessores();
    }

    public boolean removerAluno(int alunoId) {
        return this.rep.removerAluno(alunoId);
    }

    public ArrayList<Aluno> listarAlunos() throws UsuarioNaoCadastradoException {
        return this.rep.listarAlunos();
    }

}
