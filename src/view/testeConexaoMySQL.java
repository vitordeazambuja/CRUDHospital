package view;

import connection.ConexaoMySQL;

public class testeConexaoMySQL {

    public static void main(String[] args) {
        ConexaoMySQL.getInstance();
        System.out.println(ConexaoMySQL.statusConection());
        ConexaoMySQL.fecharConexao();
    }
}
