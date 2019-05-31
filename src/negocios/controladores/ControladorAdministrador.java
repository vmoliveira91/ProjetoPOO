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
    
    public boolean cadastrarDisciplina(Disciplina disciplina) throws DisciplinaJaCadastradaException {
        return this.rep.cadastrarDisciplina(disciplina);
    }

    public boolean removerDisciplina(int disciplinaId) throws DisciplinaNaoCadastradaException {
        return this.rep.removerDisciplina(disciplinaId);
    }

    public Disciplina consultarDisciplina(int disciplinaId) throws DisciplinaNaoCadastradaException {
        return this.rep.consultarDisciplina(disciplinaId);
    }

    public ArrayList<Disciplina> listarDisciplinas() throws DisciplinaNaoCadastradaException {
        return this.rep.listarDisciplinas();
    }

    public boolean cadastrarTurma(Turma turma) throws TurmaJaCadastradaException {
        return this.rep.cadastrarTurma(turma);
    }

    public boolean removerTurma(int turmaId) throws TurmaNaoCadastradaException {
        return this.rep.removerTurma(turmaId);
    }

    public Turma consultarTurma(int turmaId) throws TurmaNaoCadastradaException {
        return this.rep.consultarTurma(turmaId);
    }

    public ArrayList<Turma> listarTurmas() throws TurmaNaoCadastradaException {
        return this.rep.listarTurmas();
    }

    public boolean removerProfessor(int professorId) throws UsuarioNaoCadastradoException {
        return this.rep.removerProfessor(professorId);
    }

    public Professor consultarProfessor(int professorId) throws UsuarioNaoCadastradoException {
        return this.rep.consultarProfessor(professorId);
    }

    public ArrayList<Professor> listarProfessores() throws UsuarioNaoCadastradoException {
        return this.rep.listarProfessores();
    }

    public boolean removerAluno(int alunoId) throws UsuarioNaoCadastradoException {
        return this.rep.removerAluno(alunoId);
    }

    public Aluno consultarAluno(int alunoId) throws UsuarioNaoCadastradoException {
        return this.rep.consultarAluno(alunoId);
    }

    public ArrayList<Aluno> listarAlunos() throws UsuarioNaoCadastradoException {
        return this.rep.listarAlunos();
    }

}
