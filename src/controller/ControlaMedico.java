package controller;

import model.Medico;
import connection.ConexaoMySQL;
import model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControlaMedico {

    public boolean adicionarMedico(Medico medico){
        Connection connection = ConexaoMySQL.getInstance();
        String sql = "INSERT INTO medicos (nome, cpf, email, telefone, endereco, especialidade, numero_identificacao) VALUES (?, ?, ?, ?, ?, ?, ?)";

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

    public List<Medico> listarMedicos() {
        Connection connection = ConexaoMySQL.getInstance();
        String sql = "SELECT * FROM medicos";
        List<Medico> medicos = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Medico medico = new Medico();
                medico.setId(rs.getInt("id"));
                medico.setNome(rs.getString("nome"));
                medico.setCpf(rs.getString("cpf"));
                medico.setEmail(rs.getString("email"));
                medico.setTelefone(rs.getString("telefone"));
                medico.setEndereco(rs.getString("endereco"));
                medico.setEspecialidade(rs.getString("especialidade"));
                medico.setNumeroIdentificacao(rs.getInt("numero_identificacao"));

                medicos.add(medico);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar medicos: " + e.getMessage());
        } finally {
            ConexaoMySQL.fecharConexao();
        }
        return medicos;
    }

    public boolean editarMedico(Medico medico){
        Connection connection = ConexaoMySQL.getInstance();
        String sql = "UPDATE medicos SET nome = ?, cpf = ?, email = ?, telefone = ?, endereco = ?, especialidade = ?, numero_identificacao = ? WHERE id = ?";

        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, medico.getNome());
            pstmt.setString(2, medico.getCpf());
            pstmt.setString(3, medico.getEmail());
            pstmt.setString(4, medico.getTelefone());
            pstmt.setString(5, medico.getEndereco());
            pstmt.setString(6, medico.getEspecialidade());
            pstmt.setInt(7, medico.getNumeroIdentificacao());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e){
            System.out.println("Erro ao editar medico: " + e.getMessage());
            return false;
        } finally {
            ConexaoMySQL.fecharConexao();
        }
    }

    public boolean removerMedico(int id){
        Connection connection = ConexaoMySQL.getInstance();
        String sql = "DELETE FROM medicos WHERE id = ?";

        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e){
            System.out.println("Erro ao remover medico: " + e.getMessage());
            return false;
        } finally {
            ConexaoMySQL.fecharConexao();
        }
    }

}
