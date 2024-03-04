package utc.mx.escueladb.Models;

import javafx.scene.control.Alert;
import utc.mx.escueladb.DB.Conect;
import utc.mx.escueladb.Views.Switcher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Teacher {
    private int idTeacher;
    private String NumEmpleado, Name, LastName, SurName, Telephone, Sex, Academy;
    private Double PpH, Hours, Salary;
    private Boolean Status;
    PreparedStatement ps;
    Connection con;
    ResultSet rs;
    Switcher switcher = Switcher.getInstance();
    Conect conect = Conect.getInstance();



    public static Teacher instancia;

    private Teacher() {
    }

    private Teacher(String numEmpleado, String name, String lastName, String surName, String telephone, String sex, String academy, Double ppH, Double hours, Double salary, Boolean status) {
        NumEmpleado = numEmpleado;
        Name = name;
        LastName = lastName;
        SurName = surName;
        Telephone = telephone;
        Sex = sex;
        Academy = academy;
        PpH = ppH;
        Hours = hours;
        Salary = salary;
        Status = status;
    }

    private Teacher(int idTeacher, String numEmpleado, String name, String lastName, String surName, String telephone, String sex, String academy, Double ppH, Double hours, Double salary, Boolean status) {
        this.idTeacher = idTeacher;
        NumEmpleado = numEmpleado;
        Name = name;
        LastName = lastName;
        SurName = surName;
        Telephone = telephone;
        Sex = sex;
        Academy = academy;
        PpH = ppH;
        Hours = hours;
        Salary = salary;
        Status = status;
    }

    public void onIniciar(String user, String password) {

        String sql = "SELECT * FROM teacher where NumEmpleado =? and Password = ?";
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
                    switcher.onTeacher();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Acceso incorrecto");
                    alert.setContentText("El usuario " + user + " no existe");
                    alert.setX(0);
                    alert.setY(0);
                    alert.show();
                }

            } catch (SQLException e) {

                System.out.println(e);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Verificar conexion");
            alert.setContentText("Fallo al intentar conectar a la base de datos");
        }
    }


    public static Teacher getInstance() {
        if (instancia == null) {
            instancia = new Teacher();
        }
        return instancia;
    }


}
