package utc.mx.escueladb.Views;

import utc.mx.escueladb.View;

import static utc.mx.escueladb.ViewSwitcher.switchTo;

public class Switcher {
    public void onAdmin() {
        switchTo(View.Admin);
    }

    public void onList() {
        switchTo(View.List);
    }

    public void onLogin() {
        switchTo(View.Login);
    }

    public void onNote() {
        switchTo(View.Note);
    }

    public void onStudents() {
        switchTo(View.Students);
    }

    public void onTeacher() {
        switchTo(View.Teacher);
    }
}
