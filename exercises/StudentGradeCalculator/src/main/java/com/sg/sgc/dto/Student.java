package com.sg.sgc.dto;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private Map<String,Integer> subjectMarks = new HashMap<>();
    private String studentID;
    private String fName;
    private String lName;

    public Student(String studentID, String fName, String lName) {
        this.studentID = studentID;
        this.fName = fName;
        this.lName = lName;
    }

    public Map<String, Integer> getSubjectMarks() {
        return subjectMarks;
    }

    public void setSubjectMarks(Map<String, Integer> subjectMarks) {
        this.subjectMarks = subjectMarks;
    }

    public void addSubjectMarks(String subject, int marks) {
        this.subjectMarks.put(subject, marks);
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
