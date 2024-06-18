package controller;

import model.Consulta;
import model.Paciente;
import model.Medico;
import connection.ConexaoMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControlaConsulta {

    public boolean adicionarConsulta(Consulta consulta) {
        Connection connection = ConexaoMySQL.getInstance();
        String sql = "INSERT INTO consultas (paciente_id, medico_id, data, hora) VALUES (?, ?, ?, ?)";

        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,consulta.getPaciente().getId());
            pstmt.setInt(2,consulta.getMedico().getId());
            pstmt.setString(3,consulta.getData());
            pstmt.setString(4,consulta.getHora());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e){
            System.out.println("Erro ao adicionar consulta" + e.getMessage());
            return false;
        } finally {
            ConexaoMySQL.fecharConexao();
        }
    }

    public List<Consulta> listarConsultas() {
        Connection connection = ConexaoMySQL.getInstance();
        String sql = "SELECT c.id as consulta_id, c.data, c.hora, " +
                "p.id as paciente_id, p.nome as paciente_nome, " +
                "m.id as medico_id, m.nome as medico_nome " +
                "FROM consultas c " +
                "JOIN pacientes p ON c.paciente_id = p.id " +
                "JOIN medicos m ON c.medico_id = m.id";
        List<Consulta> consultas = new ArrayList<>();

        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("paciente_id"));
                paciente.setNome(rs.getString("paciente_nome"));

                Medico medico = new Medico();
                medico.setId(rs.getInt("medico_id"));
                medico.setNome(rs.getString("medico_nome"));

                Consulta consulta = new Consulta();
                consulta.setId(rs.getInt("consulta_id"));
                consulta.setPaciente(paciente);
                consulta.setMedico(medico);
                consulta.setData(rs.getString("data"));
                consulta.setHora(rs.getString("hora"));

                consultas.add(consulta);
            }
        } catch (SQLException e){
            System.out.println("Erro ao listar consultas" + e.getMessage());
        } finally {
            ConexaoMySQL.fecharConexao();
        }
        return consultas;
    }

    public boolean editarConsulta(Consulta consulta) {
        Connection connection = ConexaoMySQL.getInstance();
        String sql = "UPDATE consultas SET paciente_id = ?, medico_id = ?, data = ?, hora = ? WHERE id = ?";

        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,consulta.getPaciente().getId());
            pstmt.setInt(2,consulta.getMedico().getId());
            pstmt.setString(3,consulta.getData());
            pstmt.setString(4,consulta.getHora());
            pstmt.setInt(5,consulta.getId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e){
            System.out.println("Erro ao editar consulta" + e.getMessage());
            return false;
        } finally {
            ConexaoMySQL.fecharConexao();
        }
    }

    public boolean removerConsulta(int id){
        Connection connection = ConexaoMySQL.getInstance();
        String sql = "DELETE FROM consultas WHERE id = ?";

        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,id);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }catch (SQLException e){
            System.out.println("Erro ao remover consulta" + e.getMessage());
            return false;
        } finally {
            ConexaoMySQL.fecharConexao();
        }
    }
}
