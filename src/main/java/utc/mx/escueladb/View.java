package utc.mx.escueladb;

public enum View {
    Admin("admin-view.fxml"),
    List("list-view.fxml"),
    Login("students-login-view.fxml"),
    Note("note-view.fxml"),
    Students("students-view.fxml"),
    Teacher("teacher-view.fxml");


    private final String FileName;

    View(String fileName) {
        FileName = fileName;
    }

    public String getFileName() {
        return FileName;
    }
}
