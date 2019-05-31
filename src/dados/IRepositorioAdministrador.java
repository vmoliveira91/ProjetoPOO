package dados;

import negocios.entidades.*;
import negocios.excecoes.*;
import java.util.ArrayList;

public interface IRepositorioAdministrador {

    public boolean logarAdministrador(String login, String senha) throws UsuarioNaoCadastradoException, SenhaInvalidaException;
    
    public boolean cadastrarDisciplina(Disciplina disciplina) throws DisciplinaJaCadastradaException;

    public boolean removerDisciplina(int disciplinaId) throws DisciplinaNaoCadastradaException;

    public Disciplina consultarDisciplina(int disciplinaId) throws DisciplinaNaoCadastradaException;

    public ArrayList<Disciplina> listarDisciplinas() throws DisciplinaNaoCadastradaException;

    public boolean cadastrarTurma(Turma turma) throws TurmaJaCadastradaException;

    public boolean removerTurma(int turmaId) throws TurmaNaoCadastradaException;

    public Turma consultarTurma(int turmaId) throws TurmaNaoCadastradaException;

    public ArrayList<Turma> listarTurmas() throws TurmaNaoCadastradaException;

    public boolean removerProfessor(int professorId) throws UsuarioNaoCadastradoException;

    public Professor consultarProfessor(int professorId) throws UsuarioNaoCadastradoException;

    public ArrayList<Professor> listarProfessores() throws UsuarioNaoCadastradoException;

    public boolean removerAluno(int alunoId) throws UsuarioNaoCadastradoException;

    public Aluno consultarAluno(int alunoId) throws UsuarioNaoCadastradoException;

    public ArrayList<Aluno> listarAlunos() throws UsuarioNaoCadastradoException;

}
