package utc.mx.escueladb.Controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import utc.mx.escueladb.Views.Switcher;

public class SelectionController {
    //VARIABLES E INSTANCIAS
    Switcher switcher = Switcher.getInstance();


    //ELEMENTOS DE LA VISTA
    @FXML
    public MFXButton MfxBtn_Administrador, MfxBtn_Estudiante, MfxBtn_Profesor;

    public void toAdminLogin    () {
        switcher.onLoginAdmin();
    }

    public void toStudentLogin() {
        switcher.onLoginStudent();
    }

    public void toTeacherLogin() {
        switcher.onLoginTeacher();
    }
}
