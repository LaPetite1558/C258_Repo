import static java.lang.System.out;

public class Student {
    private double marks;
    private int studentID;
    private String name;

    public Student(int studentID, double marks) {
        setStudentID(studentID);
        setMarks(marks);
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void printGrade() {
        if (getMarks() > 90) {
            out.printf("Student %d grade is A.\n", getStudentID());
        } else if (getMarks() > 80 && getMarks() <=90) {
            out.printf("Student %d grade is B.\n", getStudentID());
        } else if (getMarks() > 70 && getMarks() <= 80) {
            out.printf("Student %d grade is C.\n", getStudentID());
        } else out.printf("Student %d failed.\n", getStudentID());
    }
}
