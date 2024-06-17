package controller;

import model.Medico;
import connection.ConexaoMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControlaMedico {

    public boolean adicionarMedico(Medico medico){
        Connection connection = ConexaoMySQL.getInstance();
        String sql = "INSERT INTO medicos (nome, cpf, email, telefone, endereco, especialidade, numero_identificacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,medico.getNome());
            pstmt.setString(2, medico.getCpf());
            pstmt.setString(3, medico.getEmail());
            pstmt.setString(4,medico.getTelefone());
            pstmt.setString(5,medico.getEndereco());
            pstmt.setString(6,medico.getEspecialidade());
            pstmt.setInt(7,medico.getNumeroIdentificacao());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e){
            System.out.println("Erro ao adicionar medico: " + e.getMessage());
            return false;
        } finally {
            ConexaoMySQL.fecharConexao();
        }
    }

    public List<Medico> listarMedicos(){
        
    }

}
