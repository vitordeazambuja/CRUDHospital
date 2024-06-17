package controller;

import model.Paciente;
import connection.ConexaoMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControlaPaciente {

    public boolean adicionarPaciente(Paciente paciente) {
        Connection connection = ConexaoMySQL.getInstance();
        String sql = "INSERT INTO pacientes (nome, cpf, data_nascimento, sexo, email, telefone, endereco, numero_identificacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, paciente.getNome());
            pstmt.setString(2, paciente.getCpf());
            pstmt.setString(3, paciente.getDataNascimento());
            pstmt.setString(4, paciente.getSexo());
            pstmt.setString(5, paciente.getEmail());
            pstmt.setString(6, paciente.getTelefone());
            pstmt.setString(7, paciente.getEndereco());
            pstmt.setInt(8, paciente.getNumeroIdentificacao());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar paciente: " + e.getMessage());
            return false;
        } finally {
            ConexaoMySQL.fecharConexao();
        }
    }

    public List<Paciente> listarPacientes() {
        Connection connection = ConexaoMySQL.getInstance();
        String sql = "SELECT * FROM pacientes";
        List<Paciente> pacientes = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setDataNascimento(rs.getString("data_nascimento"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setEmail(rs.getString("email"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setNumeroIdentificacao(rs.getInt("numero_identificacao"));

                pacientes.add(paciente);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pacientes: " + e.getMessage());
        } finally {
            ConexaoMySQL.fecharConexao();
        }
        return pacientes;
    }

    public boolean editarPaciente(Paciente paciente) {
        Connection connection = ConexaoMySQL.getInstance();
        String sql = "UPDATE pacientes SET nome = ?, cpf = ?, data_nascimento = ?, sexo = ?, email = ?, telefone = ?, endereco = ?, numero_identificacao = ? WHERE id = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, paciente.getNome());
            pstmt.setString(2, paciente.getCpf());
            pstmt.setString(3, paciente.getDataNascimento());
            pstmt.setString(4, paciente.getSexo());
            pstmt.setString(5, paciente.getEmail());
            pstmt.setString(6, paciente.getTelefone());
            pstmt.setString(7, paciente.getEndereco());
            pstmt.setInt(8, paciente.getNumeroIdentificacao());
            pstmt.setInt(9, paciente.getId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao editar paciente: " + e.getMessage());
            return false;
        } finally {
            ConexaoMySQL.fecharConexao();
        }
    }

    public boolean removerPaciente(int id) {
        Connection connection = ConexaoMySQL.getInstance();
        String sql = "DELETE FROM pacientes WHERE id = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao remover paciente: " + e.getMessage());
            return false;
        } finally {
            ConexaoMySQL.fecharConexao();
        }
    }
}
