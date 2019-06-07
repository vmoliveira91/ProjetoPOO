package negocios;

import negocios.entidades.*;
import negocios.excecoes.*;
import java.util.ArrayList;

public interface IFachadaAdministrador {

    public boolean logarAdministrador(String login, String senha) throws UsuarioNaoCadastradoException, SenhaInvalidaException;
    
    public boolean cadastrarDisciplina(Disciplina disciplina); // TODO - vai lançar exceção

    public boolean removerDisciplina(int disciplinaId) throws SemDisciplinaCadastradaException;

    public Disciplina consultarDisciplina(int disciplinaId) throws SemDisciplinaCadastradaException;

    public ArrayList<Disciplina> listarDisciplinas() throws SemDisciplinaCadastradaException;

    public boolean cadastrarTurma(Turma turma); // TODO - vai lançar exceção

    public boolean removerTurma(int turmaId) throws SemTurmaCadastradaException;

    public Turma consultarTurma(int turmaId) throws SemTurmaCadastradaException;

    public ArrayList<Turma> listarTurmas() throws SemTurmaCadastradaException;

    public boolean removerProfessor(int professorId) throws UsuarioNaoCadastradoException;

    public Professor consultarProfessor(int professorId) throws UsuarioNaoCadastradoException;

    public ArrayList<Professor> listarProfessores() throws UsuarioNaoCadastradoException;

    public boolean removerAluno(int alunoId) throws UsuarioNaoCadastradoException;

    public Aluno consultarAluno(int alunoId) throws UsuarioNaoCadastradoException;

    public ArrayList<Aluno> listarAlunos() throws UsuarioNaoCadastradoException;

}
