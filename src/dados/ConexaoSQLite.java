package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoSQLite {

    private Connection conexao;

    public boolean conectar() {

        try {
            String url = "jdbc:sqlite:banco/educamaster.db";

            this.conexao = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        
        return true;
    }

    public boolean desconectar() {

        try {
            if (this.conexao.isClosed() == false) {
                this.conexao.close();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;

        }

        return true;
    }

    public Statement criarStatement() {
        try {
            return this.conexao.createStatement();
        } catch (SQLException e) {
            return null;
        }
    }
}

/*     
   
    }


// DETALHES PARA VERIFICAR
// AO CRIAR UM ALUNO E COLOCAR NA TURMA, OBRIGATORIAMENTE O SISTEMA JA TEM Q CRIAR O ID DELE NA TABELA DE RENDIMENTO ESCOLAR
//VER A QUESTÃO DE VALIDAÇÃO DOS TIPOS DE DADOS PARA ENTRAR PARA O BANCO E NÃO OCORRER ERROS

//select id, turma.id_disciplina, disciplina.ementa from turma inner join disciplina on disciplina.id = turma.id_disciplina; 
//http://www.sqlitetutorial.net/sqlite-inner-join/*/