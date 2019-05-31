package dados;

import negocios.entidades.*;
import negocios.excecoes.*;
import java.util.ArrayList;

public interface IRepositorioAluno {

    public Aluno logarAluno(String login, String senha) throws UsuarioNaoCadastradoException, SenhaInvalidaException;

    public boolean cadastrarAluno(Aluno aluno) throws UsuarioJaCadastradoException;

    public ArrayList<Turma> exibirTurmasAluno(int alunoId) throws SemTurmaCadastradaException;

    public RendimentoEscolar exibirNotasAluno(int turmaId, int alunoId) throws SemAlunoMatriculadoException;

    public boolean adicionarTrabalho(int turmaId, int alunoId, String[] trabalhoNovo) throws SemEspacoParaNovoTrabalhoException;

    public ArrayList<Turma> exibirListagemTurmasDisponiveisAluno(int alunoId) throws SemTurmaCadastradaException;

    public boolean associarTurmaAluno(Aluno aluno, int turmaId);
}
