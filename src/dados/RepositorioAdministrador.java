package dados;

import negocios.entidades.*;
import negocios.excecoes.*;
import java.util.ArrayList;

public class RepositorioAdministrador implements IRepositorioAdministrador {

    @Override
    public boolean logarAdministrador(String login, String senha) throws UsuarioNaoCadastradoException, SenhaInvalidaException {

    }

    @Override
    public boolean cadastrarDisciplina(Disciplina disciplina) throws DisciplinaJaCadastradaException {

    }

    @Override
    public boolean removerDisciplina(int disciplinaId) throws DisciplinaNaoCadastradaException {

    }

    @Override
    public Disciplina consultarDisciplina(int disciplinaId) throws DisciplinaNaoCadastradaException {

    }

    @Override
    public ArrayList<Disciplina> listarDisciplinas() throws DisciplinaNaoCadastradaException {

    }

    @Override
    public boolean cadastrarTurma(Turma turma) throws TurmaJaCadastradaException {

    }

    @Override
    public boolean removerTurma(int turmaId) throws TurmaNaoCadastradaException {

    }

    @Override
    public Turma consultarTurma(int turmaId) throws TurmaNaoCadastradaException {

    }

    @Override
    public ArrayList<Turma> listarTurmas() throws TurmaNaoCadastradaException {

    }

    @Override
    public boolean removerProfessor(int professorId) throws UsuarioNaoCadastradoException {

    }

    @Override
    public Professor consultarProfessor(int professorId) throws UsuarioNaoCadastradoException {

    }

    @Override
    public ArrayList<Professor> listarProfessores() throws UsuarioNaoCadastradoException {

    }

    @Override
    public boolean removerAluno(int alunoId) throws UsuarioNaoCadastradoException {

    }

    @Override
    public Aluno consultarAluno(int alunoId) throws UsuarioNaoCadastradoException {

    }

    @Override
    public ArrayList<Aluno> listarAlunos() throws UsuarioNaoCadastradoException {

    }

}
