package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;

import java.io.*;
import java.util.*;

public class ClassRosterDaoFileImpl implements ClassRosterDao {
    public  static final String ROSTER_FILE = "src/main/java/com/sg/classroster/roster.txt";
    public static final String DELIMITER = "::";
    private Map<String, Student> students = new HashMap<>();

    @Override
    public Student addStudent(String studentID, Student student)
            throws ClassRosterDaoException {
        loadRoster();
        Student newStudent = students.put(studentID, student);
        writeRoster();
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents()
            throws ClassRosterDaoException {
        loadRoster();
        return new ArrayList<>(students.values());
    }

    @Override
    public Student getStudent(String studentID)
            throws ClassRosterDaoException {
        loadRoster();
        return students.get(studentID);
    }

    @Override
    public Student removeStudent(String studentID)
            throws ClassRosterDaoException {
        loadRoster();
        Student removedStudent = students.remove(studentID);
        writeRoster();
        return removedStudent;
    }

    private Student unmarshallStudent(String studentAsText) {
        String[] studentTokens = studentAsText.split(DELIMITER);
        String studentID = studentTokens[0];

        Student studentFromFile = new Student(studentID);

        studentFromFile.setFirstName(studentTokens[1]);
        studentFromFile.setLastName(studentTokens[2]);
        studentFromFile.setCohort(studentTokens[3]);

        return studentFromFile;
    }

    private void loadRoster() throws ClassRosterDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)
                    )
            );
        } catch (FileNotFoundException e) {
            throw new ClassRosterDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        String currLine;
        Student currStudent;

        while (scanner.hasNextLine()) {
            currLine = scanner.nextLine();
            currStudent = unmarshallStudent(currLine);
            students.put(currStudent.getStudentID(), currStudent);
        }
        scanner.close();
    }

    private String marshallStudent(Student aStudent) {
        String studentAsText = aStudent.getStudentID() + DELIMITER;
        studentAsText += aStudent.getFirstName() + DELIMITER;
        studentAsText += aStudent.getLastName() + DELIMITER;
        studentAsText += aStudent.getCohort();

        return studentAsText;
    }

    private void writeRoster() throws ClassRosterDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new ClassRosterDaoException(
                    "Could not save student data.", e);
        }

        final String[] studentAsText = new String[1];
        List<Student> studentList = this.getAllStudents();
        studentList.forEach(s -> {
            studentAsText[0] = marshallStudent(s);
            out.println(studentAsText[0]);
            out.flush();
        });
        out.close();
    }
}
