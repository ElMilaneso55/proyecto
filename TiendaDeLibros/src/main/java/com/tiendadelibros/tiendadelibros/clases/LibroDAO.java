package com.tiendadelibros.tiendadelibros.clases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    public List<Libro> getLibros() {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT id, titulo, autor, editorial, precio, imagen FROM Libros";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Libro libro = new Libro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getString("editorial"),
                    rs.getDouble("precio"),
                    rs.getString("imagen")
                );
                lista.add(libro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Libro> buscarPorTitulo(String titulo) {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM Libros WHERE titulo LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + titulo + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Libro libro = new Libro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getString("editorial"),
                    rs.getDouble("precio"),
                    rs.getString("imagen")
                );
                lista.add(libro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<String> obtenerEditoriales() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT DISTINCT editorial FROM Libros";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(rs.getString("editorial"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<String> obtenerAutores() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT DISTINCT autor FROM Libros";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(rs.getString("autor"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Libro> buscarPorEditorial(String editorial) {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM Libros WHERE editorial = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, editorial); // Filtrar por editorial
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Libro libro = new Libro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getString("editorial"),
                    rs.getDouble("precio"),
                    rs.getString("imagen")
                );
                lista.add(libro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Libro> buscarPorAutor(String autor) {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM Libros WHERE autor = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, autor); // Filtrar por autor
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Libro libro = new Libro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getString("editorial"),
                    rs.getDouble("precio"),
                    rs.getString("imagen")
                );
                lista.add(libro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}