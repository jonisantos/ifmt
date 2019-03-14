/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.SingleConnection;
import java.sql.*;
import java.util.*;
import model.DetalhesObra;
import model.Usuario;

/**
 *
 * @author Joni
 */
public class DaoDetalhesObra {

    private Connection connection;

    public DaoDetalhesObra() {
        connection = SingleConnection.getConnection();
    }

    public void salvar(DetalhesObra obras) {

        try {

            String sql = "insert into detalhes_obra(titulo, data, tecnico,dimensoe_fisica, autor, procendencia, tipo) values (?, ?, ?,?, ?, ?,?)";;
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setString(1, obras.getTitulo());
            insert.setString(2, obras.getData());
            insert.setString(3, obras.getTecnico());
            insert.setString(4, obras.getDimensoe_fisica());
            insert.setString(5, obras.getAutor());
            insert.setString(6, obras.getProcedencia());
            insert.setString(7, obras.getTipo());

            insert.execute();
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public List<DetalhesObra> listar() throws Exception {
        List<DetalhesObra> listar = new ArrayList<DetalhesObra>();

        String sql = "select * from detalhes_obra";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {

            DetalhesObra obras = new DetalhesObra();
            obras.setId(resultSet.getLong("id"));
            obras.setTitulo(resultSet.getString("Titulo"));
            obras.setData(resultSet.getString("data"));
            obras.setTecnico(resultSet.getString("tecnico"));
            obras.setDimensoe_fisica(resultSet.getString("dimensoe_fisica"));
            obras.setAutor(resultSet.getString("autor"));
            obras.setProcedencia(resultSet.getString("procedencia"));
            obras.setTipo(resultSet.getString("tipo"));
            listar.add(obras);
        }

        return listar;
    }

    public void delete(String id) {

        try {
            String sql = "delete from detalhes_obra where id = '" + id + "'";
            PreparedStatement preparedStatement = connection
                    .prepareStatement(sql);
            preparedStatement.execute();

            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }

    public DetalhesObra consultar(String id) throws Exception {
        String sql = "select * from detalhes_obras where id='" + id + "'";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            DetalhesObra obras = new DetalhesObra();
            obras.setId(resultSet.getLong("id"));
            obras.setTitulo(resultSet.getString("Titulo"));
            obras.setData(resultSet.getString("data"));
            obras.setTecnico(resultSet.getString("tecnico"));
            obras.setDimensoe_fisica(resultSet.getString("dimensoe_fisica"));
            obras.setAutor(resultSet.getString("autor"));
            obras.setProcedencia(resultSet.getString("procedencia"));
            obras.setTipo(resultSet.getString("tipo"));
            return obras;
        }

        return null;
    }

    public void atualizar(DetalhesObra obra) {
        try {
            String sql = "update detalhes_obra set titulo = ?, data = ?, tecnico = ?, "
                    + "dimensoe_fisica = ?, autor = ?, procendencia = ?, tipo = ?  where id = "
                    + obra.getId();

            PreparedStatement preparedStatement = connection
                    .prepareStatement(sql);
            preparedStatement.setString(1, obra.getTitulo());
            preparedStatement.setString(2, obra.getData());
            preparedStatement.setString(3, obra.getTecnico());
            preparedStatement.setString(4, obra.getDimensoe_fisica());
            preparedStatement.setString(5, obra.getAutor());
            preparedStatement.setString(6, obra.getProcedencia());
            preparedStatement.setString(7, obra.getTipo());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
