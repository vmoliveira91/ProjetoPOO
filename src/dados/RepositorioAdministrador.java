package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import negocios.entidades.*;
import negocios.excecoes.*;
import java.util.ArrayList;

public class RepositorioAdministrador implements IRepositorioAdministrador {

    private ConexaoSQLite conexao;

    public RepositorioAdministrador() {
        this.conexao = new ConexaoSQLite();
    }

    @Override
    public boolean logarAdministrador(String login, String senha) throws UsuarioNaoCadastradoException, SenhaInvalidaException {
        this.conexao.conectar();

        int idConsultado = 0;
        String loginConsultado = null;
        String senhaConsultado = null;

        ResultSet resultSet = null;
        Statement statement = null;

        String sqlSelectLogin = "select * from administrador where login = '" + login + "';";

        statement = this.conexao.criarStatement();

        try {
            resultSet = statement.executeQuery(sqlSelectLogin);

            idConsultado = resultSet.getInt("id");
            loginConsultado = resultSet.getString("login");
            senhaConsultado = resultSet.getString("senha");
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

        if (loginConsultado == null) {
            throw new UsuarioNaoCadastradoException("Usuário não encontrado!");
        }
        if (!senha.equals(senhaConsultado)) {
            throw new SenhaInvalidaException("Senha inválida!");
        }

        return true;
    }

    @Override
    public boolean cadastrarDisciplina(Disciplina disciplina) {
        this.conexao.conectar();

        Statement statement = null;

        statement = this.conexao.criarStatement();

        String sqlInsert = "insert into disciplina(nome, ementa) "
                + "values('" + disciplina.getNome() + "', '" + disciplina.getEmenta() + "');";

        try {
            statement.executeUpdate(sqlInsert);
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
    public boolean removerDisciplina(int disciplinaId) { // TODO - ajeitar a remoção da disciplina, remover a turma e os alunos daquela turma
        this.conexao.conectar();

        Statement statement = null;

        statement = this.conexao.criarStatement();

        String sqlDelete = "delete from disciplina where id = " + disciplinaId + ";";

        try {
            statement.executeUpdate(sqlDelete);
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
    public ArrayList<Disciplina> listarDisciplinas() throws SemDisciplinaCadastradaException {
        this.conexao.conectar();

        ArrayList<Disciplina> listaDisciplina = new ArrayList();

        ResultSet resultSet = null;
        Statement statement = null;

        int discId = 0;
        String disciplinaNome = null;
        String disciplinaEmenta = null;

        String sqlSelect = "select * from disciplina";

        statement = this.conexao.criarStatement();

        try {
            resultSet = statement.executeQuery(sqlSelect);

            if (resultSet.next()) {
                do {
                    discId = resultSet.getInt("id");
                    disciplinaNome = resultSet.getString("nome");
                    disciplinaEmenta = resultSet.getString("ementa");

                    listaDisciplina.add(new Disciplina(discId, disciplinaNome, disciplinaEmenta));
                } while (resultSet.next());
            } else {
                throw new SemDisciplinaCadastradaException("Não existem disciplinas cadastradas!");
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
        return listaDisciplina;
    }

    @Override
    public boolean cadastrarTurma(Turma turma) throws CapacidadeInvalidaException {
        this.conexao.conectar();

        Statement statement = null;

        if (turma.getCapacidadaDaTurma() <= 0) {
            throw new CapacidadeInvalidaException("Capacidade de alunos na turma inválida!");
        }

        String sqlInsert = "insert into turma(id_disciplina, id_professor, capacidade_turma) "
                + "values(" + turma.getDisciplina().getId() + ", 0, " + turma.getCapacidadaDaTurma() + ");";

        statement = this.conexao.criarStatement();

        try {
            statement.executeUpdate(sqlInsert);
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
    public boolean removerTurma(int turmaId) {
        this.conexao.conectar();

        Statement statement = null;

        String sqlDelete = "delete from turma where id = " + turmaId + ";";

        statement = this.conexao.criarStatement();

        try {
            statement.executeUpdate(sqlDelete);
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
    public ArrayList<Turma> listarTurmas() throws SemTurmaCadastradaException {
        this.conexao.conectar();

        ResultSet resultSet1 = null;
        ResultSet resultSet2 = null;
        Statement statement1 = null;
        Statement statement2 = null;

        ArrayList<Turma> listaTurma = new ArrayList();

        int idTurma = 0;
        int disciplinaId = 0;
        String disciplinaNome = null;
        String disciplinaEmenta = null;
        int professorId = 0;
        String professorNome = null;
        int capacidadeTurma = 0;

        Disciplina disciplina = null;
        Professor professor = null;
        Turma turma = null;

        String sqlSelect1 = "select t.id, t.id_disciplina as id_disciplina, d.nome as nome_disciplina, d.ementa, t.id_professor as id_professor, "
                + "p.nome as nome_professor, capacidade_turma from turma as t\n"
                + "inner join disciplina as d on t.id_disciplina = d.id\n"
                + "left join professor as p on t.id_professor = p.id;";

        statement1 = this.conexao.criarStatement();

        try {
            resultSet1 = statement1.executeQuery(sqlSelect1);

            if (resultSet1.next()) {
                do {
                    idTurma = resultSet1.getInt("id");
                    professorId = resultSet1.getInt("id_professor");
                    professorNome = resultSet1.getString("nome_professor");
                    disciplinaId = resultSet1.getInt("id_disciplina");
                    disciplinaNome = resultSet1.getString("nome_disciplina");
                    disciplinaEmenta = resultSet1.getString("ementa");
                    capacidadeTurma = resultSet1.getInt("capacidade_turma");

                    professor = new Professor(professorId, professorNome, "", 0, 0, 0, "", "");
                    disciplina = new Disciplina(disciplinaId, disciplinaNome, disciplinaEmenta);

                    String sqlSelect2 = "select r.id_aluno as id_aluno, a.nome as nome_aluno from rendimentoescolar as r\n"
                            + "inner join aluno as a on r.id_aluno = a.id where id_turma = " + idTurma + ";";

                    statement2 = this.conexao.criarStatement();

                    resultSet2 = statement2.executeQuery(sqlSelect2);

                    ArrayList<Aluno> alunos = new ArrayList();

                    if (resultSet2.next()) {
                        do {
                            int id = resultSet2.getInt("id_aluno");
                            String nome = resultSet2.getString("nome_aluno");
                            alunos.add(new Aluno(id, nome, 0, 0, 0, 0, "", ""));
                        } while (resultSet2.next());
                    }

                    listaTurma.add(new Turma(idTurma, disciplina, professor, capacidadeTurma, alunos));

                } while (resultSet1.next());
            } else {
                throw new SemTurmaCadastradaException("Não existem turmas cadastradas!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                resultSet1.close();
                statement1.close();
                if (resultSet2 != null) {
                    resultSet2.close();
                    statement2.close();
                }
                this.conexao.desconectar();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return listaTurma;
    }

    @Override
    public boolean removerProfessor(int professorId) {
        this.conexao.conectar();

        Statement statement = null;

        statement = this.conexao.criarStatement();

        String sqlDelete = "delete from professor where id = " + professorId + ";";

        try {
            statement.executeUpdate(sqlDelete);
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
    public ArrayList<Professor> listarProfessores() throws UsuarioNaoCadastradoException {
        this.conexao.conectar();

        ArrayList<Professor> listaProfessor = new ArrayList();

        ResultSet resultSet = null;
        Statement statement = null;

        int professorId = 0;
        String professorNome = null;
        String professorCargo = null;
        String professorData = null;
        String professorLogin = null;

        String sqlSelect = "select * from professor";

        statement = this.conexao.criarStatement();

        try {
            resultSet = statement.executeQuery(sqlSelect);

            if (resultSet.next()) {
                do {
                    professorId = resultSet.getInt("id");
                    professorNome = resultSet.getString("nome");
                    professorCargo = resultSet.getString("cargo");
                    professorData = resultSet.getString("data_nascimento");
                    professorLogin = resultSet.getString("nome_usuario");

                    String[] data = professorData.split("/");

                    listaProfessor.add(new Professor(professorId, professorNome, professorCargo, Integer.parseInt(data[0]), Integer.parseInt(data[1]),
                            Integer.parseInt(data[2]), professorLogin, null));
                } while (resultSet.next());
            } else {
                throw new UsuarioNaoCadastradoException("Não existem professores cadastrados!");
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
        return listaProfessor;
    }

    @Override
    public boolean removerAluno(int alunoId) {
        this.conexao.conectar();

        Statement statement = null;

        statement = this.conexao.criarStatement();

        String sqlDelete = "delete from aluno where id = " + alunoId + ";";

        try {
            statement.executeUpdate(sqlDelete);
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
    public ArrayList<Aluno> listarAlunos() throws UsuarioNaoCadastradoException {
        this.conexao.conectar();

        ArrayList<Aluno> listaAluno = new ArrayList();

        ResultSet resultSet = null;
        Statement statement = null;

        int alunoId = 0;
        String alunoNome = null;
        int alunoPeriodo = 0;
        String alunoData = null;
        String alunoLogin = null;

        String sqlSelect = "select * from aluno";

        statement = this.conexao.criarStatement();

        try {
            resultSet = statement.executeQuery(sqlSelect);

            if (resultSet.next()) {
                do {
                    alunoId = resultSet.getInt("id");
                    alunoNome = resultSet.getString("nome");
                    alunoPeriodo = resultSet.getInt("periodo");
                    alunoData = resultSet.getString("data_nascimento");
                    alunoLogin = resultSet.getString("nome_usuario");

                    String[] data = alunoData.split("/");

                    listaAluno.add(new Aluno(alunoId, alunoNome, Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]),
                            alunoPeriodo, alunoLogin, null));
                } while (resultSet.next());
            } else {
                throw new UsuarioNaoCadastradoException("Não existem alunos cadastrados!");
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
        return listaAluno;
    }

}
