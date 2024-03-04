package utc.mx.escueladb.Models;

import javafx.scene.control.Alert;
import utc.mx.escueladb.DB.Conect;
import utc.mx.escueladb.Views.Switcher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Students {
    private int idStudent;
    private String Boleta, Name, LastName, SurName, Age, Sex, Covey, Grade, Career, Street, Number, Suburb, Password;
    Switcher switcher = Switcher.getInstance();
    Conect conect = Conect.getInstance();
    public static Students instancia;
    PreparedStatement ps;
    Connection con;
    ResultSet rs;

    private Students() {
    }

    private Students(int idStudent, String boleta, String name, String lastName, String surName, String age, String sex, String covey, String grade, String career, String street, String number, String suburb, String password) {
        this.idStudent = idStudent;
        Boleta = boleta;
        Name = name;
        LastName = lastName;
        SurName = surName;
        Age = age;
        Sex = sex;
        Covey = covey;
        Grade = grade;
        Career = career;
        Street = street;
        Number = number;
        Suburb = suburb;
        Password = password;
    }

    private Students(String boleta, String name, String lastName, String surName, String age, String sex, String covey, String grade, String career, String street, String number, String suburb, String password) {
        Boleta = boleta;
        Name = name;
        LastName = lastName;
        SurName = surName;
        Age = age;
        Sex = sex;
        Covey = covey;
        Grade = grade;
        Career = career;
        Street = street;
        Number = number;
        Suburb = suburb;
        Password = password;
    }

    public String getBoleta() {
        return Boleta;
    }

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }

    public String getSurName() {
        return SurName;
    }

    public String getAge() {
        return Age;
    }

    public String getSex() {
        return Sex;
    }

    public String getCovey() {
        return Covey;
    }

    public String getGrade() {
        return Grade;
    }

    public String getCareer() {
        return Career;
    }

    public String getStreet() {
        return Street;
    }

    public String getNumber() {
        return Number;
    }

    public String getSuburb() {
        return Suburb;
    }

    public String getPassword() {
        return Password;
    }

    public void onIniciar(String user, String password) {
        String sql = "SELECT * FROM student where Boleta =? and Password = ?";
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
                    alert.setContentText("El usuario " + user + " o contraseña incorrectos");
                    alert.show();
                }

            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error en la base de datos");
                alert.setContentText(String.valueOf(e) + "O el usuario es incorrecto");
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Verificar conexion");
            alert.setContentText("Fallo al intentar conectar a la base de datos");
            alert.show();
        }
    }

    public static Students getInstancia() {
        if (instancia == null) {
            instancia = new Students();
        }
        return instancia;
    }
}
