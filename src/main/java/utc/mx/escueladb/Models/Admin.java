package utc.mx.escueladb.Models;

import javafx.scene.control.Alert;
import utc.mx.escueladb.DB.Conect;
import utc.mx.escueladb.Views.Switcher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
    public static Admin instancia;
    Switcher switcher = Switcher.getInstance();
    Conect conect = Conect.getInstance();
    PreparedStatement ps;
    Connection con;
    ResultSet rs;

    private int idAdmin;
    private String Nombre, ApePat, ApeMat, Sexo;
    boolean esatdo;

    private Admin() {
    }

    public Admin(int idAdmin, String nombre, String apePat, String apeMat, String sexo, boolean esatdo) {
        this.idAdmin = idAdmin;
        Nombre = nombre;
        ApePat = apePat;
        ApeMat = apeMat;
        Sexo = sexo;
        this.esatdo = esatdo;
    }

    public Admin(String nombre, String apePat, String apeMat, String sexo, boolean esatdo) {
        Nombre = nombre;
        ApePat = apePat;
        ApeMat = apeMat;
        Sexo = sexo;
        this.esatdo = esatdo;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApePat() {
        return ApePat;
    }

    public String getApeMat() {
        return ApeMat;
    }

    public String getSexo() {
        return Sexo;
    }

    public boolean isEsatdo() {
        return esatdo;
    }
    public void onIniciar(String user, String password) {
        String sql = "SELECT * FROM admin where numEmpleado =? and Password = ?";
        con = conect.getConnection();
        if (con != null) {
            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, user);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Acceso correcto");
                    alert.setContentText("Bienvenid@ " + user);
                    alert.show();
                    switcher.onStudents();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Acceso incorrecto");
                    alert.setContentText("El usuario " + user);
                    alert.show();
                }

            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error en la base de datos");
                alert.setContentText(String.valueOf(e) + "o el usuario es incorrecto");
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Verificar conexion");
            alert.setContentText("Fallo al intentar conectar a la base de datos");
            alert.show();
        }
    }











    //sinlgleton
    public static Admin getIntance() {
        if (instancia == null) {
            instancia = new Admin();
        }
        return instancia;
    }
}
