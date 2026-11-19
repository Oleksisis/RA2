package dam.castellet2627;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AtletaDAO implements DAO<Atleta> {

    @Override 

    public void add(Atleta atleta) {
        String sql = "INSERT INTO deportistas (nombre, cod_deporte) VALUES (?, ?)"; // замените имя таблицы, если оно отличается в вашей базе
        
        try (Connection conn = ConnectionManager.getConnection("resources/config.xml");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, atleta.getNombre());
            pstmt.setInt(2, atleta.getCodDeporte());
            
            pstmt.executeUpdate();
            System.out.println("Atleta afegit correctament!");
            
        } catch (SQLException e) {
            System.err.println("Error al afegir l'atleta: " + e.getMessage());
        }
    }

    @Override 
    public List<Atleta> getAll() {
        List<Atleta> atletes = new ArrayList<>();
        String sql = "SELECT cod, nombre, cod_deporte FROM deportistas";

        try (Connection conn = ConnectionManager.getConnection("resources/config.xml");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("cod");
                String nombre = rs.getString("nombre");
                int codDeporte = rs.getInt("cod_deporte");
                
                atletes.add(new Atleta(id, nombre, codDeporte));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtenir els atletes: " + e.getMessage());
        }

        return atletes;
    }

    // Дополнительный метод для получения атлетов по конкретному ID спорта (требуется в задании)
    public List<Atleta> getAtletesByEsport(int esportId) {
        List<Atleta> atletes = new ArrayList<>();
        String sql = "SELECT cod, nombre, cod_deporte FROM deportistas WHERE cod_deporte = ?";

        try (Connection conn = ConnectionManager.getConnection("resources/config.xml");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, esportId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("cod");
                    String nombre = rs.getString("nombre");
                    int codDeporte = rs.getInt("cod_deporte");
                    
                    atletes.add(new Atleta(id, nombre, codDeporte));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al filtrar atletes per esport: " + e.getMessage());
        }

        return atletes;
    }
}
