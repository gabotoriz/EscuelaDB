package utc.mx.escueladb.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conect {
    static Settings settings = new Settings();
    private static Connection connection;
    private static Conect instancia;

    private Conect() {
    }

    public Connection getConnection() {
        try {
            Class.forName(settings.getDriver());
            connection = DriverManager.getConnection(settings.getUrl() + settings.getDataBase(), settings.getUser(), settings.getPssword());
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return connection;
    }

    public void dropConnection() throws SQLException {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
            connection.close();
        } finally {
            connection.close();
        }
    }

    //SINGLETON


    public static Conect getInstance() {
        if (instancia == null) {
            instancia = new Conect();
        }
        return instancia;
    }
}
