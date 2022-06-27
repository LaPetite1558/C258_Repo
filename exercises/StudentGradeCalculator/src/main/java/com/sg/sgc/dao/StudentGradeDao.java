package com.sg.sgc.dao;

import com.sg.sgc.dto.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentGradeDao {
    private final Map<String, Student> students = new HashMap<>();

    public List<Student> getAllStudents() {
        loadDB();
        return new ArrayList<>(students.values());
    }

    private Student unmarshallStudent(ResultSet studentSet) throws SQLException {
        String studentID = studentSet.getString("student_id");
        String fName = studentSet.getString("first_name");
        String lName = studentSet.getString("last_name");

        return new Student(studentID, fName, lName);
    }

    private void assignSubjectMarks(ResultSet recordSet) throws SQLException {
        String studentID = recordSet.getString("student_id");
        String subjectID = recordSet.getString("subject_id");
        int marks = recordSet.getInt("marks");

        students.get(studentID).addSubjectMarks(subjectID, marks);

    }

    private void loadDB() {
        String STUDENT_DATA = "select * from students";
        String RECORD_DATA = "select * from records";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/c258",
                    "root", "fxckYouAH#19");
            PreparedStatement prepStudent = conn.prepareStatement(STUDENT_DATA);
            ResultSet studentSet = prepStudent.executeQuery();
            while (studentSet.next()) {
                Student newStudent = unmarshallStudent(studentSet);
                students.put(newStudent.getStudentID(), newStudent);
            }
            PreparedStatement prepRecord = conn.prepareStatement(RECORD_DATA);
            ResultSet recordSet = prepRecord.executeQuery();

            while (recordSet.next()) {
                assignSubjectMarks(recordSet);
            }
            conn.close();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
