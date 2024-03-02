package utc.mx.escueladb;

public enum View {
    Admin("admin-view.fxml"),
    List("list-view.fxml"),
    LoginStudent("students-login-view.fxml"),
    Note("note-view.fxml"),
    Students("students-view.fxml"),
    Teacher("teacher-view.fxml"),
    LoginAdmin("admin-login-view.fxm,l"),
    LoginTeacher("teacher-admin-view.fxml"),
    Selection("selection-view.fxml");


    private final String FileName;

    View(String fileName) {
        FileName = fileName;
    }

    public String getFileName() {
        return FileName;
    }
}
