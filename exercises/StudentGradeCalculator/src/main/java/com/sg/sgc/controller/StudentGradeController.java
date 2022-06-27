package com.sg.sgc.controller;

import com.sg.sgc.dao.StudentGradeDao;
import com.sg.sgc.dto.Student;
import com.sg.sgc.grader.Grader;
import com.sg.sgc.view.StudentGradeView;
import com.sg.sgc.view.UserIO;
import com.sg.sgc.view.UserIOConsoleImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentGradeController {
    private StudentGradeView view;
    private StudentGradeDao dao;

    public StudentGradeController(StudentGradeView view, StudentGradeDao dao) {
        this.view = view;
        this.dao = dao;
    }
    public void run() {
        listStudents();
        viewLowest();
        viewHighest();
    }

    private void listStudents() {
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }

    private void viewLowest() {
        List<Student> studentList = dao.getAllStudents();
        view.displayLowestScoring(studentList);
    }

    private void viewHighest() {
        List<Student> studentList = dao.getAllStudents();
        view.displayHighestScoring(studentList);
    }
}
