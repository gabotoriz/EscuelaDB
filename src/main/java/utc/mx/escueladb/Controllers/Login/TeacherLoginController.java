package utc.mx.escueladb.Controllers.Login;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import utc.mx.escueladb.Models.Teacher;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class TeacherLoginController implements Initializable {
    Teacher teacher = Teacher.getInstance();
    PreparedStatement ps;
    Connection connection;
    ResultSet set;
    @FXML
    private MFXButton MfxBtn_IniciarSesion, MfxBtn_IniciarSesionLeft, MfxBtn_Registrar;
    @FXML
    private TextField JTF_Usuario;
    @FXML
    private PasswordField KPF_Password;
    @FXML
    private Pane P_Left, P_Right;

    public MFXButton getMfxBtn_IniciarSesion() {
        return MfxBtn_IniciarSesion;
    }

    public MFXButton getMfxBtn_IniciarSesionLeft() {
        return MfxBtn_IniciarSesionLeft;
    }

    public MFXButton getMfxBtn_Registrar() {
        return MfxBtn_Registrar;
    }

    public TextField getJTF_Usuario() {
        return JTF_Usuario;
    }

    public PasswordField getKPF_Password() {
        return KPF_Password;
    }

    public Pane getP_Left() {
        return P_Left;
    }

    public Pane getP_Right() {
        return P_Right;
    }

    public void registrar() {
        getP_Left().setVisible(false);
        getP_Right().setVisible(true);
    }

    public void iniciar() {
        getP_Left().setVisible(true);
        getP_Right().setVisible(false);
    }

    public void onIniciar() {
        String usuario = getJTF_Usuario().getText().toString().trim();
        String password = getKPF_Password().getText().toString().trim();
        teacher.onIniciar(usuario, password);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getP_Right().setVisible(false);

    }
}
