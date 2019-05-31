package negocios;

import negocios.controladores.*;
import negocios.entidades.*;
import negocios.excecoes.*;
import java.util.ArrayList;

public class Fachada implements IFachadaAdministrador, IFachadaAluno, IFachadaProfessor {

    private ControladorAluno controladorAluno;
    private ControladorAdministrador controladorAdministrador;
    private ControladorProfessor controladorProfessor;
    private static Fachada instancia;

    /*
   *  Singleton
     */
    private Fachada() {
        this.controladorAluno = new ControladorAluno();
        this.controladorAdministrador = new ControladorAdministrador();
        this.controladorProfessor = new ControladorProfessor();
    }

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    /*
   * Fim Singleton
     */

 /*
   * Gets e Sets
     */
    public ControladorAluno getControladorAluno() {
        return this.controladorAluno;
    }

    public void setControladorAluno(ControladorAluno controladorAluno) {
        this.controladorAluno = controladorAluno;
    }

    public ControladorAdministrador getControladorAdministrador() {
        return this.controladorAdministrador;
    }

    public void setControladorAdministrador(ControladorAdministrador controladorAdministrador) {
        this.controladorAdministrador = controladorAdministrador;
    }

    public ControladorProfessor getControladorProfessor() {
        return this.controladorProfessor;
    }

    public void setControladorProfessor(ControladorProfessor controladorProfessor) {
        this.controladorProfessor = controladorProfessor;
    }

    /*
   * Fim Gets e Sets
     */

 /*
   *  Interface IFachadaProfessor
     */
    @Override
    public Professor logarProfessor(String login, String senha) throws UsuarioNaoCadastradoException, SenhaInvalidaException {
        return this.controladorProfessor.logarProfessor(login, senha);
    }

    @Override
    public boolean cadastrarProfessor(Professor professor) throws UsuarioJaCadastradoException {
        return this.controladorProfessor.cadastrarProfessor(professor);
    }

    @Override
    public ArrayList<Turma> exibirTurmasProfessor(int professorId) throws SemTurmaCadastradaException {
        return this.controladorProfessor.exibirTurmasProfessor(professorId);
    }

    @Override
    public ArrayList<RendimentoEscolar> exibirNotasProfessor(int turmaId) throws SemAlunoMatriculadoException {
        return this.controladorProfessor.exibirNotasProfessor(turmaId);
    }

    @Override
    public boolean atualizarNotasProfessor(int turmaId, int alunoId, float nota1, float nota2) throws NotaInvalidaException {
        return this.controladorProfessor.atualizarNotasProfessor(turmaId, alunoId, nota1, nota2);
    }

    @Override
    public boolean atualizarNotasTrabalhosProfessor(int turmaId, int alunoId, float[] notaTrabalhos) throws NotaInvalidaException {
        return this.controladorProfessor.atualizarNotasTrabalhosProfessor(turmaId, alunoId, notaTrabalhos);
    }

    @Override
    public ArrayList<Turma> exibirListagemTurmasDisponiveisProfessor(int professorId) throws SemTurmaCadastradaException {
        return this.controladorProfessor.exibirListagemTurmasDisponiveisProfessor(professorId);
    }

    @Override
    public boolean associarTurmaProfessor(Professor professor,int turmaId) {
        return this.controladorProfessor.associarTurmaProfessor(professor, turmaId);
    }

    /*
   * Fim Interface IFachadaProfessor
     */

 /*
   *  Interface IFachadaAluno
     */
    @Override
    public Aluno logarAluno(String login, String senha) throws UsuarioNaoCadastradoException, SenhaInvalidaException {
        return this.controladorAluno.logarAluno(login, senha);
    }

    @Override
    public boolean cadastrarAluno(Aluno aluno) throws UsuarioJaCadastradoException {
        return this.controladorAluno.cadastrarAluno(aluno);
    }

    @Override
    public ArrayList<Turma> exibirTurmasAluno(int alunoId) throws SemTurmaCadastradaException {
        return this.controladorAluno.exibirTurmasAluno(alunoId);
    }

    @Override
    public RendimentoEscolar exibirNotasAluno(int turmaId, int alunoId) throws SemAlunoMatriculadoException {
        return this.controladorAluno.exibirNotasAluno(turmaId, alunoId);
    }

    @Override
    public boolean adicionarTrabalho(int turmaId, int alunoId, String[] trabalhoNovo) throws SemEspacoParaNovoTrabalhoException {
        return this.controladorAluno.adicionarTrabalho(turmaId, alunoId, trabalhoNovo);
    }

    @Override
    public ArrayList<Turma> exibirListagemTurmasDisponiveisAluno(int alunoId) throws SemTurmaCadastradaException {
        return this.controladorAluno.exibirListagemTurmasDisponiveisAluno(alunoId);
    }

    @Override
    public boolean associarTurmaAluno(Aluno aluno, int turmaId) {
        return this.controladorAluno.associarTurmaAluno(aluno, turmaId);
    }

    /*
   * Fim Interface IFachadaAluno
     */

 /*
   *  Interface IFachadaAdministrador
     */
    @Override
    public boolean logarAdministrador(String login, String senha) throws UsuarioNaoCadastradoException, SenhaInvalidaException {
        return this.controladorAdministrador.logarAdministrador(login, senha);
    }
    
    @Override
    public boolean cadastrarDisciplina(Disciplina disciplina) throws DisciplinaJaCadastradaException {
        return this.controladorAdministrador.cadastrarDisciplina(disciplina);
    }

    @Override
    public boolean removerDisciplina(int disciplinaId) throws DisciplinaNaoCadastradaException {
        return this.controladorAdministrador.removerDisciplina(disciplinaId);
    }

    @Override
    public Disciplina consultarDisciplina(int disciplinaId) throws DisciplinaNaoCadastradaException {
        return this.controladorAdministrador.consultarDisciplina(disciplinaId);
    }

    @Override
    public ArrayList<Disciplina> listarDisciplinas() throws DisciplinaNaoCadastradaException {
        return this.controladorAdministrador.listarDisciplinas();
    }

    @Override
    public boolean cadastrarTurma(Turma turma) throws TurmaJaCadastradaException {
        return this.controladorAdministrador.cadastrarTurma(turma);
    }

    @Override
    public boolean removerTurma(int turmaId) throws TurmaNaoCadastradaException {
        return this.controladorAdministrador.removerTurma(turmaId);
    }

    @Override
    public Turma consultarTurma(int turmaId) throws TurmaNaoCadastradaException {
        return this.controladorAdministrador.consultarTurma(turmaId);
    }

    @Override
    public ArrayList<Turma> listarTurmas() throws TurmaNaoCadastradaException {
        return this.controladorAdministrador.listarTurmas();
    }

    @Override
    public boolean removerProfessor(int professorId) throws UsuarioNaoCadastradoException {
        return this.controladorAdministrador.removerProfessor(professorId);
    }

    @Override
    public Professor consultarProfessor(int professorId) throws UsuarioNaoCadastradoException {
        return this.controladorAdministrador.consultarProfessor(professorId);
    }

    @Override
    public ArrayList<Professor> listarProfessores() throws UsuarioNaoCadastradoException {
        return this.controladorAdministrador.listarProfessores();
    }

    @Override
    public boolean removerAluno(int alunoId) throws UsuarioNaoCadastradoException {
        return this.controladorAdministrador.removerAluno(alunoId);
    }

    @Override
    public Aluno consultarAluno(int alunoId) throws UsuarioNaoCadastradoException {
        return this.controladorAdministrador.consultarAluno(alunoId);
    }

    @Override
    public ArrayList<Aluno> listarAlunos() throws UsuarioNaoCadastradoException {
        return this.controladorAdministrador.listarAlunos();
    }
    /*
   * Fim Interface IFachadaAdministrador
     */
}
