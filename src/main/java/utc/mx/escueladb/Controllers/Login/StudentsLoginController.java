package utc.mx.escueladb.Controllers.Login;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import utc.mx.escueladb.Models.Students;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentsLoginController implements Initializable {
    Students students = Students.getInstancia();

    @FXML
    private PasswordField JPF_Password;
    @FXML
    private Pane P_Left, P_Right;
    @FXML
    private MFXButton MfxBtn_RegistrarLeft, MfxBtn_IniciarSesionLeft, MfxBtn_IniciarSesion;
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
        String usuario = getJTF_Usuario().getText();
        String password = getJPF_Password().getText();
        students.onIniciar(usuario, password);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getP_Right().setVisible(false);
    }
}