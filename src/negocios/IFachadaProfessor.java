package negocios;

import negocios.entidades.*;
import negocios.excecoes.*;
import java.util.ArrayList;

public interface IFachadaProfessor {

    public Professor logarProfessor(String login, String senha) throws UsuarioNaoCadastradoException, SenhaInvalidaException;

    public boolean cadastrarProfessor(Professor professor) throws UsuarioJaCadastradoException;

    public ArrayList<Turma> exibirTurmasProfessor(int professorId) throws SemTurmaCadastradaException;

    public ArrayList<RendimentoEscolar> exibirNotasProfessor(int turmaId) throws SemAlunoMatriculadoException;

    public boolean atualizarNotasProfessor(int turmaId, int alunoId, float nota1, float nota2) throws NotaInvalidaException;

    public boolean atualizarNotasTrabalhosProfessor(int turmaId, int alunoId, float[] notaTrabalhos) throws NotaInvalidaException;

    public ArrayList<Turma> exibirListagemTurmasDisponiveisProfessor(int professorId) throws SemTurmaCadastradaException;

    public boolean associarTurmaProfessor(Professor professor, int turmaId);
}
