package com.sg.sgc;


import com.sg.sgc.controller.StudentGradeController;
import com.sg.sgc.dao.StudentGradeDao;
import com.sg.sgc.view.StudentGradeView;
import com.sg.sgc.view.UserIO;
import com.sg.sgc.view.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO myIO = new UserIOConsoleImpl();
        StudentGradeView myView = new StudentGradeView(myIO);
        StudentGradeDao myDao = new StudentGradeDao();
        StudentGradeController controller = new StudentGradeController(myView, myDao);
        controller.run();
    }
}
