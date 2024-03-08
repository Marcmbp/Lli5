import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseConnectExample {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Carrega el controlador JDBC per a Base
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            // Estableix la connexió a la base de dades de Base
            String url = "jdbc:hsqldb:file:/home/tolo/Insync/tcatala@iedib.net/Google Drive/_iedib/2223/ptd/lliuraments/ava2/lli6/bd/editorial.odb";
            String user = "tolo";
            String password = "tolo";
            //conn = DriverManager.getConnection(url, user, password);
            conn = DriverManager.getConnection(url);
            // Executa una consulta SQL
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Llibres");
            // Processa el resultat de la consulta
            while (rs.next()) {
                String titol = rs.getString("Titol");
                String autor = rs.getString("Autor");
                int any = rs.getInt("Any");
                System.out.println(titol + " de " + autor + " (" + any + ")");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Tanca la connexió i els recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
