package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    private static String status = "Não conectou...";
    private static final String URL = "jdbc:mysql://localhost/CRUDHospital";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    // Método Construtor da Classe
    public ConexaoMySQL() {
    }

    // Método de Conexão
    public static Connection getInstance() {
        Connection connection = null;

        try {
            // Conectando ao banco de dados
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (connection != null) {
                status = "STATUS--->Conectado com sucesso!";
            } else {
                status = "STATUS--->Não foi possível realizar conexão";
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar ao Banco de Dados: " + e.getMessage());
        }

        return connection;
    }

    // Método que retorna o status da conexão
    public static String statusConection() {
        return status;
    }

    // Método que fecha a conexão
    public static boolean fecharConexao() {
        try {
            Connection connection = getInstance();
            if (connection != null && !connection.isClosed()) {
                connection.close();
                status = "STATUS--->Conexão fechada";
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        return false;
    }

    // Método que reinicia a conexão
    public static Connection reiniciarConexao() {
        fecharConexao();
        return getInstance();
    }
}
