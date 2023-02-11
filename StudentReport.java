import java.util.List;
import java.util.Scanner;

public class StudentReport {

	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    StudentsReportingSystem system = new StudentsReportingSystem();

	    System.out.println("Enter the number of students: ");
	    int numOfStudents = scanner.nextInt();

	    for (int i = 0; i < numOfStudents; i++) {
	        System.out.println("Enter the name of student " + (i + 1) + ": ");
	        String name = scanner.next();
	        system.addStudent(name);

	        for (int j = 0; j < 2; j++) {
	            System.out.println("Enter marks for student "+(i+1)+" semester " + (j + 1) + ": ");
	            System.out.println("English: ");
	            double english = scanner.nextDouble();
	            system.addMarks(name, "English", english);

	            System.out.println("Maths: ");
	            double maths = scanner.nextDouble();
	            system.addMarks(name, "Maths", maths);

	            System.out.println("Science: ");
	            double science = scanner.nextDouble();
	            system.addMarks(name, "Science", science);
	        }
	    }

	    System.out.println("Class average: " + system.getClassAverage());
	    System.out.println("English average: " + system.getSubjectAverage("English"));
	    System.out.println("Maths average: " + system.getSubjectAverage("Maths"));
	    System.out.println("Science average: " + system.getSubjectAverage("Science"));

	    List<Student> topStudents = system.getTopConsistentStudents();
	    System.out.println("Top 2 consistent students: ");
	    for (Student student : topStudents) {
	        System.out.println(student.getName());
	    }
	}
}
