package utc.mx.escueladb.Views;

import utc.mx.escueladb.View;

import static utc.mx.escueladb.ViewSwitcher.switchTo;

public class Switcher {
    //ADMINISTRADOR
    public void onAdmin() {
        switchTo(View.Admin);
    }

    public void onLoginAdmin() {
        switchTo(View.LoginAdmin);
    }

    //ESTUDIANTES
    public void onStudents() {
        switchTo(View.Students);
    }

    public void onLoginStudent() {
        switchTo(View.LoginStudent);
    }

    //PROFESORES
    public void onTeacher() {
        switchTo(View.Teacher);
    }

    public void onLoginTeacher() {
        switchTo(View.LoginTeacher);
    }
    //SECCIONES

    public void onNote() {
        switchTo(View.Note);
    }

    public void onList() {
        switchTo(View.List);
    }
}
