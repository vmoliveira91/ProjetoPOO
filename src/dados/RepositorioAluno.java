package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import negocios.entidades.*;
import negocios.excecoes.*;
import java.util.ArrayList;

public class RepositorioAluno implements IRepositorioAluno {

    private ConexaoSQLite conexao;

    public RepositorioAluno() {
        this.conexao = new ConexaoSQLite();
    }

    @Override
    public Aluno logarAluno(String login, String senha) throws UsuarioNaoCadastradoException, SenhaInvalidaException {
        this.conexao.conectar();

        int idConsultado = 0;
        String nomeConsultado = null;
        int periodoConsultado = 0;
        int diaConsultado = 0;
        int mesConsultado = 0;
        int anoConsultado = 0;
        String loginConsultado = null;
        String senhaConsultado = null;

        String dataParaBanco = null;

        ResultSet resultSet = null;
        Statement statement = null;
        String sqlSelectLogin = "select * from aluno where nome_usuario = '" + login + "';";

        statement = this.conexao.criarStatement();
        try {

            resultSet = statement.executeQuery(sqlSelectLogin);

            idConsultado = resultSet.getInt("id");
            nomeConsultado = resultSet.getString("nome");
            loginConsultado = resultSet.getString("nome_usuario");
            senhaConsultado = resultSet.getString("senha");
            dataParaBanco = resultSet.getString("data_nascimento");
            periodoConsultado = resultSet.getInt("periodo");

            String[] data = dataParaBanco.split("/");
            diaConsultado = Integer.parseInt(data[0]);
            mesConsultado = Integer.parseInt(data[1]);
            anoConsultado = Integer.parseInt(data[2]);
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

        return new Aluno(idConsultado, nomeConsultado, diaConsultado, mesConsultado, anoConsultado, periodoConsultado, loginConsultado, senhaConsultado);
    }

    @Override
    public boolean cadastrarAluno(Aluno aluno) throws UsuarioJaCadastradoException {
        this.conexao.conectar();
        String login = aluno.getLogin();

        ResultSet resultSelect1 = null;
        ResultSet resultSelect2 = null;

        Statement statement = null;

        String sqlSelect1 = "select * from professor where nome_usuario = '" + login + "';";
        String sqlSelect2 = "select * from aluno where nome_usuario = '" + login + "';";

        statement = this.conexao.criarStatement();

        try {
            resultSelect1 = statement.executeQuery(sqlSelect1);
            resultSelect2 = statement.executeQuery(sqlSelect2);

            if (!resultSelect1.next() && !resultSelect2.next()) {
                LocalDate data = aluno.getDataNascimento();
                String dataStr = data.getDayOfMonth() + "/" + data.getMonthValue() + "/" + data.getYear();

                String sqlInsert = "insert into aluno(nome, nome_usuario, senha, data_nascimento, periodo) "
                        + "values('" + aluno.getNome() + "', '" + aluno.getLogin() + "', '" + aluno.getSenha()
                        + "', '" + dataStr + "', " + aluno.getPeriodo() + ");";

                statement.executeUpdate(sqlInsert);
            } else {
                throw new UsuarioJaCadastradoException("Usuário já cadastrado!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                resultSelect1.close();
                resultSelect2.close();
                statement.close();
                this.conexao.desconectar();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return true;
    }

    @Override
    public ArrayList<Turma> exibirTurmasAluno(int alunoId) throws SemTurmaCadastradaException {
        this.conexao.conectar();

        ResultSet resultSet = null;
        Statement statement = null;

        ArrayList<Turma> turma = new ArrayList<Turma>();

        String sqlSelect = "select r.id_turma as id, d.nome as discNome, p.nome as profNome from rendimentoescolar as r\n"
                + "inner join turma as t on r.id_turma = t.id\n"
                + "inner join disciplina as d on t.id_disciplina = d.id\n"
                + "left join professor as p on t.id_professor = p.id\n"
                + "where r.id_aluno = " + alunoId + ";";

        statement = this.conexao.criarStatement();

        try {
            resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()) {
                int turmaId = resultSet.getInt("id");
                String disciplinaNome = resultSet.getString("discNome");
                String professorNome = resultSet.getString("profNome");

                Disciplina disciplina = new Disciplina(0, disciplinaNome, "");
                Professor professor = new Professor(0, professorNome, "", 0, 0, 0, "", "");

                turma.add(new Turma(turmaId, disciplina, professor, 0, null));
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
            throw new SemTurmaCadastradaException("Sem turmas matriculado!");
        }
        return turma;
    }

    @Override
    public RendimentoEscolar exibirNotasAluno(int turmaId, int alunoId) {
        this.conexao.conectar();

        RendimentoEscolar rendimento = null;

        ResultSet resultSet = null;
        Statement statement = null;

        String sqlSelect = "select id, nota1prova, nota2prova, trabalho1, trabalho1nota, trabalho2, trabalho2nota, trabalho3, trabalho3nota, "
                + "trabalho4, trabalho4nota from rendimentoescolar\n"
                + "where id_turma = " + turmaId + " and id_aluno = " + alunoId + ";";

        statement = this.conexao.criarStatement();

        try {
            resultSet = statement.executeQuery(sqlSelect);

            int id = resultSet.getInt("id");
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

            rendimento = new RendimentoEscolar(null, null, nota1, nota2, trabalhos, notaTrabalhos);
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
        return rendimento;
    }

    @Override
    public boolean adicionarTrabalho(int turmaId, int alunoId, String[] trabalhoNovo) {
        this.conexao.conectar();

        Statement statement = null;

        String sqlUpdate = "update rendimentoescolar set trabalho1 = '" + trabalhoNovo[0] + "', trabalho2 = '" + trabalhoNovo[1] + "', "
                + "trabalho3 = '" + trabalhoNovo[2] + "', trabalho4 = '" + trabalhoNovo[3] + "'\n"
                + "where id_turma = " + turmaId + " and id_aluno = " + alunoId + ";";

        statement = this.conexao.criarStatement();

        try {
            statement.executeUpdate(sqlUpdate);
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
    public ArrayList<Turma> exibirListagemTurmasDisponiveisAluno(int alunoId) throws SemTurmaCadastradaException {
        this.conexao.conectar();

        ResultSet resultSet = null;
        Statement statement = null;

        ArrayList<Turma> turmas = new ArrayList();
        ArrayList<Integer> turmasId = new ArrayList();

        String sqlSelect1 = "select id_turma as id from rendimentoescolar"
                + " where id_aluno = " + alunoId + ";";
        
        statement = this.conexao.criarStatement();

        try {
            resultSet = statement.executeQuery(sqlSelect1);
            
            while (resultSet.next()) {
                turmasId.add(resultSet.getInt("id"));
            }

            String sqlSelect2 = "select t.id as id, t.capacidade_turma as cap, d.nome as discNome, p.nome as profNome from turma as t\n"
                    + "inner join disciplina as d on t.id_disciplina = d.id\n"
                    + "left join professor as p on t.id_professor = p.id\n"
                    + "where t.id not in (";
            
            if(!turmasId.isEmpty()) {
                for (int i = 0; i < turmasId.size(); i++) {
                    if (i != turmasId.size() - 1) {
                        sqlSelect2 += turmasId.get(i) + ",";
                    } else {
                        sqlSelect2 += turmasId.get(i) + ");";
                    }
                }
            } else {
                sqlSelect2 += ");";
            }
            
            resultSet = statement.executeQuery(sqlSelect2);
            
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                int cap = resultSet.getInt("cap");
                String discNome = resultSet.getString("discNome");
                String profNome = resultSet.getString("profNome");
                
                Disciplina disciplina = new Disciplina(0, discNome, "");
                Professor professor = new Professor(0, profNome, "", 0, 0, 0, "", "");

                turmas.add(new Turma(id, disciplina, professor, cap, null));                
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
        if (turmas.isEmpty()) {
            throw new SemTurmaCadastradaException("Não há turmas disponíveis!");
        }
        return turmas;
    }

    @Override
    public boolean associarTurmaAluno(Aluno aluno, int turmaId, int capacidadeTurma) throws TurmaLotadaException {
        this.conexao.conectar();
        
        ResultSet resultSet = null;
        Statement statement = null;
        
        String sqlSelect = "select count(*) as quantAlunos from rendimentoescolar where id_turma = " + turmaId + ";";
        
        statement = this.conexao.criarStatement();
        
        try {
            resultSet = statement.executeQuery(sqlSelect);
            
            int quantAlunos = resultSet.getInt("quantAlunos");
            
            if(capacidadeTurma == quantAlunos) {
                throw new TurmaLotadaException("Turma lotada!");
            } else {
                String sqlInsert = "insert into rendimentoescolar(id_turma, id_aluno, nota1prova, nota2prova, trabalho1, trabalho1nota,"
                        + " trabalho2, trabalho2nota, trabalho3, trabalho3nota, trabalho4, trabalho4nota) values (" + turmaId + ", "
                        + aluno.getId() + ", " + 0 + ", " + 0 + ", '', " + 0 + ", ''," + 0 + ", '', " + 0 + ", '', " + 0 + ");";
                
                statement.executeUpdate(sqlInsert);
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
        return true;
    }

}
