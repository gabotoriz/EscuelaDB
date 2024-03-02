package utc.mx.escueladb.Controllers.Login;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import utc.mx.escueladb.DB.Conect;
import utc.mx.escueladb.Views.Switcher;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentsLocinController implements Initializable {
    Switcher switcher = Switcher.getInstance();
    PreparedStatement ps;
    Connection con;
    ResultSet rs;
    Conect conect = Conect.getInstance();
    @FXML
    private PasswordField JPF_Password;
    @FXML
    private Pane P_Left, P_Right;
    @FXML
    private MFXButton MfxBtn_RegistrarLeft, MfxBtn_IniciarSesionLeft,MfxBtn_IniciarSesion;
    @FXML
    private TextField JTF_Usuario;

    public Pane getP_Left() {
        return P_Left;
    }

    public Pane getP_Right() {
        return P_Right;
    }

    public void registrar() {
        getP_Right().setVisible(true);
        getP_Left().setVisible(false);
    }

    public void iniciar() {
        getP_Right().setVisible(false);
        getP_Left().setVisible(true);
    }

    public PasswordField getJPF_Password() {
        return JPF_Password;
    }

    public MFXButton getMfxBtn_RegistrarLeft() {
        return MfxBtn_RegistrarLeft;
    }

    public MFXButton getMfxBtn_IniciarSesionLeft() {
        return MfxBtn_IniciarSesionLeft;
    }

    public MFXButton getMfxBtn_IniciarSesion() {
        return MfxBtn_IniciarSesion;
    }

    public TextField getJTF_Usuario() {
        return JTF_Usuario;
    }

    public void onIniciar() throws SQLException {
        String usuario = getJTF_Usuario().getText().toString();
        String password = getJPF_Password().getText().toString();

        String sql = "SELECT * FROM student where Boleta =? and Password = ?";
        con = conect.getConnection();
        if (con != null) {
            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, usuario);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Acceso correcto");
                    alert.setContentText("Bienvenid@ " + usuario);
                    switcher.onStudents();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Acceso incorrecto");
                    alert.setContentText("El usuario " + usuario + " no existe");
                    alert.setX(0);
                    alert.setY(0);
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getP_Right().setVisible(false);
    }
}