package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;

import java.util.List;

public interface ClassRosterDao {
    Student addStudent(String studentID, Student student)
            throws ClassRosterDaoException;

    List<Student> getAllStudents()
            throws ClassRosterDaoException;

    Student getStudent(String studentID)
            throws ClassRosterDaoException;

    Student removeStudent(String studentID)
            throws ClassRosterDaoException;
}
