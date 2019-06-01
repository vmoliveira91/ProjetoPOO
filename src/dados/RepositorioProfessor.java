package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import negocios.entidades.*;
import negocios.excecoes.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RepositorioProfessor implements IRepositorioProfessor {

    private ConexaoSQLite conexao;

    public RepositorioProfessor() {
        this.conexao = new ConexaoSQLite();
    }

    @Override
    public Professor logarProfessor(String login, String senha) throws UsuarioNaoCadastradoException, SenhaInvalidaException {
        this.conexao.conectar();

        int idConsultado = 0;
        String nomeConsultado = null;
        String cargoConsultado = null;
        int diaConsultado = 0;
        int mesConsultado = 0;
        int anoConsultado = 0;
        String loginConsultado = null;
        String senhaConsultado = null;

        String dataParaBanco = null;

        ResultSet resultSet = null;
        Statement statement = null;
        String sqlSelectLogin = "SELECT * FROM PROFESSOR WHERE nome_usuario = '" + login + "';";

        statement = this.conexao.criarStatement();
        try {

            resultSet = statement.executeQuery(sqlSelectLogin);

            idConsultado = resultSet.getInt("id");
            nomeConsultado = resultSet.getString("nome");
            loginConsultado = resultSet.getString("nome_usuario");
            senhaConsultado = resultSet.getString("senha");
            dataParaBanco = resultSet.getString("data_nascimento");
            cargoConsultado = resultSet.getString("cargo");

            diaConsultado = Integer.parseInt(dataParaBanco.substring(0, 2));
            mesConsultado = Integer.parseInt(dataParaBanco.substring(3, 5));
            anoConsultado = Integer.parseInt(dataParaBanco.substring(6));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                resultSet.close();
                statement.close();
                this.conexao.desconectar();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        if (nomeConsultado == null) {
            throw new UsuarioNaoCadastradoException("Usuário não encontrado!");
        }
        if (!senha.equals(senhaConsultado)) {
            throw new SenhaInvalidaException("Senha inválida!");
        }

        return new Professor(idConsultado, nomeConsultado, cargoConsultado, diaConsultado, mesConsultado, anoConsultado, loginConsultado, senhaConsultado);
    }

    @Override
    public boolean cadastrarProfessor(Professor professor) throws UsuarioJaCadastradoException {
        this.conexao.conectar();
        ResultSet resultSet = null;
        Statement statement = null;

        String sqlInsert = "INSERT INTO professor(cargo,data_nascimento,senha, nome_usuario, nome) "
                + "VALUES('" + professor.getCargo() + "','11/02/1987','" + professor.getSenha() + "','" + professor.getLogin() + "','" + professor.getNome() + "');";

        statement = this.conexao.criarStatement();
        try {
            resultSet = statement.executeQuery(sqlInsert);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new UsuarioJaCadastradoException("Usuário já cadastrado!");

        } finally {
            try {
                resultSet.close();
                statement.close();
                this.conexao.desconectar();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return true;
    }

    @Override
    public ArrayList<Turma> exibirTurmasProfessor(int professorId) throws SemTurmaCadastradaException {
        this.conexao.conectar();

        ResultSet resultSet = null;
        Statement statement = null;

        ArrayList<Turma> turma = new ArrayList<Turma>();
        
        String sqlSelect = "select distinct t.id as id, t.capacidade_turma as cap, t.id_disciplina as discId, d.nome as discNome from turma as t\n" +
                "inner join disciplina as d on t.id_disciplina = d.id\n" +
                "where t.id_professor = " + professorId + ";";

        statement = this.conexao.criarStatement();

        try {
            resultSet = statement.executeQuery(sqlSelect);
            while(resultSet.next()) {
                int turmaId = resultSet.getInt("id");
                int turmaCapacidade = resultSet.getInt("cap");
                int disciplinaId = resultSet.getInt("discId");
                String disciplinaNome = resultSet.getString("discNome");

                Disciplina disciplina = new Disciplina(disciplinaId, disciplinaNome, "");

                turma.add(new Turma(turmaId, disciplina, null, turmaCapacidade, null));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                resultSet.close();
                statement.close();
                this.conexao.desconectar();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (turma.isEmpty()) {
            throw new SemTurmaCadastradaException("Sem turma cadastrada!");
        }
        return turma;
    }

    @Override
    public ArrayList<RendimentoEscolar> exibirNotasProfessor(int turmaId) throws SemAlunoMatriculadoException {
        this.conexao.conectar();

        ArrayList<RendimentoEscolar> rendimentos = new ArrayList();
        
        ResultSet resultSet = null;
        Statement statement = null;

        String sqlSelect = "select rend.id as id, rend.id_turma as turmaId, rend.id_aluno as alunoId, a.nome as alunoNome, "
                + "rend.nota1prova, rend.nota2prova, rend.trabalho1, rend.trabalho1nota, rend.trabalho2, rend.trabalho2nota, "
                + "rend.trabalho3, rend.trabalho3nota, rend.trabalho4, rend.trabalho4nota from rendimentoescolar as rend\n"
                + "inner join aluno as a on rend.id_aluno = a.id\n"
                + "where id_turma = " + turmaId + ";";

        statement = this.conexao.criarStatement();

        try {
            resultSet = statement.executeQuery(sqlSelect);
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                turmaId = resultSet.getInt("turmaId");
                int alunoId = resultSet.getInt("alunoId");
                String alunoNome = resultSet.getString("alunoNome");
                float nota1 = resultSet.getFloat("nota1prova");
                float nota2 = resultSet.getFloat("nota2prova");
                String[] trabalhos = new String[4];
                float[] notaTrabalhos = new float[4];
                trabalhos[0] = resultSet.getString("trabalho1");
                notaTrabalhos[0] = resultSet.getFloat("trabalho1nota");
                trabalhos[1] = resultSet.getString("trabalho2");
                notaTrabalhos[1] = resultSet.getFloat("trabalho2nota");
                trabalhos[2] = resultSet.getString("trabalho3");
                notaTrabalhos[2] = resultSet.getFloat("trabalho3nota");
                trabalhos[3] = resultSet.getString("trabalho4");
                notaTrabalhos[3] = resultSet.getFloat("trabalho4nota");

                rendimentos.add(new RendimentoEscolar(new Turma(turmaId, null, null, 0, null), new Aluno(alunoId, alunoNome, 0, 0, 0, 0, "", ""),
                        nota1, nota2, trabalhos, notaTrabalhos));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if (rendimentos.isEmpty()) {
            throw new SemAlunoMatriculadoException("Sem aluno matriculado!");
        } else {
            return rendimentos;
        }
    }

    @Override
    public boolean atualizarNotasProfessor(int turmaId, int alunoId, float nota1, float nota2) throws NotaInvalidaException {
        this.conexao.conectar();
        ResultSet resultSet = null;
        Statement statement = null;

        if (nota1 > 10 || nota1 < 0 || nota2 > 10 || nota2 < 0) {
            throw new NotaInvalidaException("Nota inválida!");
        }

        statement = this.conexao.criarStatement();

        String sqlSelect = "select id_aluno from rendimentoescolar where id_aluno = " + alunoId + ";";

        try {
            resultSet = statement.executeQuery(sqlSelect);

            if (!resultSet.next()) {
                String sqlInsert = "insert into rendimentoescolar (id_turma, id_aluno, nota1prova, nota2prova) values "
                        + "(" + turmaId + "," + alunoId + "," + nota1 + "," + nota2 + ");";

                statement.executeUpdate(sqlInsert);
            } else {
                String sqlUpdate = "UPDATE rendimentoescolar SET nota1prova = " + nota1 + ", nota2prova = " + nota2 + " "
                        + "WHERE id_aluno = " + alunoId + " AND id_turma= " + turmaId + ";";
                
                statement.executeUpdate(sqlUpdate);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                statement.close();
                this.conexao.desconectar();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return true;
    }

    @Override
    public boolean atualizarNotasTrabalhosProfessor(int turmaId, int alunoId, float[] notaTrabalhos) throws NotaInvalidaException {
        this.conexao.conectar();
        ResultSet resultSet = null;
        Statement statement = null;

        for (int i = 0; i < 4; i++) {
            if (notaTrabalhos[i] > 10 || notaTrabalhos[i] < 0) {
                throw new NotaInvalidaException("Nota inválida!");
            }
        }

        String sqlUpdate = "update rendimentoescolar set trabalho1nota = " + notaTrabalhos[0] + ", trabalho2nota = " + notaTrabalhos[1]
                + ", trabalho3nota = " + notaTrabalhos[2] + ", trabalho4nota = " + notaTrabalhos[3]
                + " where id_aluno = " + alunoId + " and id_turma = " + turmaId + ";";

        statement = this.conexao.criarStatement();
        try {
            statement.executeUpdate(sqlUpdate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                statement.close();
                this.conexao.desconectar();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return true;
    }

    @Override
    public ArrayList<Turma> exibirListagemTurmasDisponiveisProfessor(int professorId) throws SemTurmaCadastradaException {
        this.conexao.conectar();
        ResultSet resultSet = null;
        Statement statement = null;

        ArrayList<Turma> turmas = new ArrayList();

        String sqlSelect = "select t.id as id, d.nome as discNome from turma as t\n"
                + "inner join disciplina as d on t.id_disciplina = d.id\n"
                + "where t.id_professor <> " + professorId + ";";

        statement = this.conexao.criarStatement();

        try {
            resultSet = statement.executeQuery(sqlSelect);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String disciplinaNome = resultSet.getString("discNome");

                turmas.add(new Turma(id, new Disciplina(0, disciplinaNome, ""), new Professor(0, "", "", 0, 0, 0, "", ""), 0, null));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                resultSet.close();
                statement.close();
                this.conexao.desconectar();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (turmas.isEmpty()) {
            throw new SemTurmaCadastradaException("Sem turma cadastrada!");
        }
        return turmas;
    }

    @Override
    public boolean associarTurmaProfessor(Professor professor, int turmaId) {
        this.conexao.conectar();
        ResultSet resultSet = null;
        Statement statement = null;
        
        String sqlUpdate = "update turma set id_professor = " + professor.getId() + " "
                + "where id = " + turmaId + ";";
        
        statement = this.conexao.criarStatement();
        
        try {
            statement.executeUpdate(sqlUpdate);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            try {
                //resultSet.close();
                statement.close();
                this.conexao.desconectar();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        return true;
    }

}
