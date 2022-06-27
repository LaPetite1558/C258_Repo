package com.sg.sgc.view;

import com.sg.sgc.dto.Student;
import com.sg.sgc.grader.Grader;
import javafx.util.Pair;

import java.util.List;
import java.util.Map;

public class StudentGradeView {
    private UserIO io;

    public StudentGradeView(UserIO io) {
        this.io = io;
    }

    public void displayStudentList(List<Student> studentList) {
        studentList.forEach(s ->
                io.print(String.format("#%s : %s %s",
                        s.getStudentID(),
                        s.getfName(),
                        s.getlName())));
        io.readString("Please hit enter to continue");
    }

    public void displayStudent(Student student) {
        if(student != null) {
            io.print(student.getStudentID());
            io.print(student.getfName() + " " + student.getlName());
            io.print("");
        } else io.print("No such student.");
        io.readString("Please hit enter to continue.");
    }

    public void displayLowestScoring(List<Student> studentList) {
        Pair<Student, Map.Entry<String,Integer>> lowestStudent = Grader.studentLowestScore(studentList);
        io.print(String.format("%s %s with %d marks for %s",
                lowestStudent.getKey().getfName(),
                lowestStudent.getKey().getlName(),
                lowestStudent.getValue().getValue(),
                lowestStudent.getValue().getKey()));
    }

    public void displayHighestScoring(List<Student> studentList) {
        Pair<Student, Map.Entry<String,Integer>> highestStudent = Grader.studentHighestScore(studentList);
        io.print(String.format("%s %s with %d marks for %s",
                highestStudent.getKey().getfName(),
                highestStudent.getKey().getlName(),
                highestStudent.getValue().getValue(),
                highestStudent.getValue().getKey()));
    }

//    public void displayStudentGrades(List<Student> studentList) {
//
//    }
}
