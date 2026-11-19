package dam.castellet2627;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EsportDAO implements DAO<Esport> {

    @Override
    public void add(Esport esport) {
        String sql = "INSERT INTO deportes (nombre) VALUES (?)"; // Проверьте название вашей таблицы в БД
        
        try (Connection conn = ConnectionManager.getConnection("config.xml");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, esport.getNombre());
            pstmt.executeUpdate();
            System.out.println("Esport afegit correctament!");
            
        } catch (SQLException e) {
            System.err.println("Error al afegir l'esport: " + e.getMessage());
        }
    }

    @Override
    public List<Esport> getAll() {
        List<Esport> esports = new ArrayList<>();
        String sql = "SELECT cod, nombre FROM deportes"; // Проверьте название таблицы и колонок

        try (Connection conn = ConnectionManager.getConnection("config.xml");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("cod");
                String nombre = rs.getString("nombre");
                esports.add(new Esport(id, nombre));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtenir els esports: " + e.getMessage());
        }

        return esports;
    }
}