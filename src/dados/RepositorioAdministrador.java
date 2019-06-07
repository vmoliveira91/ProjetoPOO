package dados;

import negocios.entidades.*;
import negocios.excecoes.*;
import java.util.ArrayList;

public class RepositorioAdministrador implements IRepositorioAdministrador {

    @Override
    public boolean logarAdministrador(String login, String senha) throws UsuarioNaoCadastradoException, SenhaInvalidaException {
        return true;
    }

    @Override
    public boolean cadastrarDisciplina(Disciplina disciplina) {
        return true;
    }

    @Override
    public boolean removerDisciplina(int disciplinaId) throws SemDisciplinaCadastradaException {
        return true;
    }

    @Override
    public Disciplina consultarDisciplina(int disciplinaId) throws SemDisciplinaCadastradaException {
        return null;
    }

    @Override
    public ArrayList<Disciplina> listarDisciplinas() throws SemDisciplinaCadastradaException {
        return null;
    }

    @Override
    public boolean cadastrarTurma(Turma turma) {
        return true;
    }

    @Override
    public boolean removerTurma(int turmaId) throws SemTurmaCadastradaException {
        return true;
    }

    @Override
    public Turma consultarTurma(int turmaId) throws SemTurmaCadastradaException {
        return null;
    }

    @Override
    public ArrayList<Turma> listarTurmas() throws SemTurmaCadastradaException {
        return null;
    }

    @Override
    public boolean removerProfessor(int professorId) throws UsuarioNaoCadastradoException {
        return true;
    }

    @Override
    public Professor consultarProfessor(int professorId) throws UsuarioNaoCadastradoException {
        return null;
    }

    @Override
    public ArrayList<Professor> listarProfessores() throws UsuarioNaoCadastradoException {
        return null;
    }

    @Override
    public boolean removerAluno(int alunoId) throws UsuarioNaoCadastradoException {
        return true;
    }

    @Override
    public Aluno consultarAluno(int alunoId) throws UsuarioNaoCadastradoException {
        return null;
    }

    @Override
    public ArrayList<Aluno> listarAlunos() throws UsuarioNaoCadastradoException {
        return null;
    }

}
