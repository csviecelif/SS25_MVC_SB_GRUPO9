package com.pucpralunos.abrigo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pucpralunos.abrigo.models.Cachorro;

public class CachorroDAO {

    // private List<Cachorro> cachorros = new ArrayList<>();
    private static final String URL = "jdbc:mysql://localhost:3306/banco1";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public void addCachorro(String nome, String raca) {
        String sql = "INSERT INTO cachorros (nome, raca) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, raca);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cachorro> listarCachorros() {
        List<Cachorro> lista = new ArrayList<>();
        String sql = "SELECT * FROM cachorros";
        
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String raca = rs.getString("raca");
                lista.add(new Cachorro(nome, raca));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;

    }
}
