package dados;

import negocios.entidades.*;
import negocios.excecoes.*;
import java.util.ArrayList;

public interface IRepositorioAdministrador {

    public boolean logarAdministrador(String login, String senha) throws UsuarioNaoCadastradoException, SenhaInvalidaException;
    
    public boolean cadastrarDisciplina(Disciplina disciplina);

    public boolean removerDisciplina(int disciplinaId);

    public ArrayList<Disciplina> listarDisciplinas() throws SemDisciplinaCadastradaException;

    public boolean cadastrarTurma(Turma turma) throws CapacidadeInvalidaException;

    public boolean removerTurma(int turmaId) throws SemTurmaCadastradaException;

    public ArrayList<Turma> listarTurmas() throws SemTurmaCadastradaException;

    public boolean removerProfessor(int professorId);

    public ArrayList<Professor> listarProfessores() throws UsuarioNaoCadastradoException;

    public boolean removerAluno(int alunoId);

    public ArrayList<Aluno> listarAlunos() throws UsuarioNaoCadastradoException;

}
