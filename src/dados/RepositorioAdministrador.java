package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
    public boolean removerDisciplina(int disciplinaId) {
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
            //throw new TurmaJaCadastradaException("Turma já cadastrada!");
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
    public Turma consultarTurma(int turmaId) throws SemTurmaCadastradaException {
        return null;
    }

    @Override
    public ArrayList<Turma> listarTurmas() throws SemTurmaCadastradaException {
        return null;
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
