package dados;

import negocios.entidades.*;
import negocios.excecoes.*;
import java.util.ArrayList;

public class RepositorioAluno implements IRepositorioAluno {
    
    @Override
    public Aluno logarAluno(String login, String senha) throws UsuarioNaoCadastradoException, SenhaInvalidaException {

    }

    @Override
    public boolean cadastrarAluno(Aluno aluno) throws UsuarioJaCadastradoException {

    }

    @Override
    public ArrayList<Turma> exibirTurmasAluno(int alunoId) throws SemTurmaCadastradaException {

    }

    @Override
    public RendimentoEscolar exibirNotasAluno(int turmaId, int alunoId) throws SemAlunoMatriculadoException {

    }

    @Override
    public boolean adicionarTrabalho(int turmaId, int alunoId, String[] trabalhoNovo) throws SemEspacoParaNovoTrabalhoException {

    }

    @Override
    public ArrayList<Turma> exibirListagemTurmasDisponiveisAluno(int alunoId) throws SemTurmaCadastradaException {

    }

    @Override
    public boolean associarTurmaAluno(Aluno aluno, int turmaId) {

    }

}
