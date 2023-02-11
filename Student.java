import java.util.*;

class Student {
    private String name;
    Map<String, Double> marks;

    public Student(String name) {
        this.name = name;
        this.marks = new HashMap<>();
    }

    public void addMark(String subject, double mark) {
        this.marks.put(subject, mark);
    }

    public double getAverage() {
        double sum = 0.0;
        for (double mark : this.marks.values()) {
            sum += mark;
        }
        return sum / this.marks.size();
    }

    public String getName() {
        return this.name;
    }
}

class StudentsReportingSystem {
    private Map<String, Student> students;

    public StudentsReportingSystem() {
        this.students = new HashMap<>();
    }

    public void addStudent(String name) {
        this.students.put(name, new Student(name));
    }

    public void addMarks(String name, String subject, double mark) {
        Student student = this.students.get(name);
        if (student != null) {
            student.addMark(subject, mark);
        } else {
            System.out.println("Error: student not found");
        }
    }

    public double getClassAverage() {
        double sum = 0.0;
        int count = 0;
        for (Student student : this.students.values()) {
            sum += student.getAverage();
            count++;
        }
        return sum / count;
    }

    public double getSubjectAverage(String subject) {
        double sum = 0.0;
        int count = 0;
        for (Student student : this.students.values()) {
            Double mark = student.marks.get(subject);
            if (mark != null) {
                sum += mark;
                count++;
            }
        }
        return sum / count;
    }

    public List<Student> getTopConsistentStudents() {
        List<Student> students = new ArrayList<>(this.students.values());
        students.sort((s1, s2) -> Double.compare(s2.getAverage(), s1.getAverage()));
        return students.subList(0, 2);
    }
}
