import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter Student Information:");
        System.out.print("1. Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("2. First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("3. Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("4. Course: ");
        String course = scanner.nextLine();
        System.out.print("5. Section: ");
        String section = scanner.nextLine();

      
        System.out.println("\nSTUDENT INFORMATION");
        System.out.println("Student Id: " + studentId);
        System.out.println("Student name: " + firstName + " " + lastName);
        System.out.println("Course: " + course);
        System.out.println("Section: " + section);

        
        System.out.println("\nEnter Scores:");
        System.out.print("1. Midterm Exam Score: ");
        int midtermScore = scanner.nextInt();
        System.out.print("2. Final Exam Score: ");
        int finalScore = scanner.nextInt();
        System.out.print("3. Project Score: ");
        int projectScore = scanner.nextInt();
        System.out.print("4. Attendance Percentage: ");
        int attendanceScore = scanner.nextInt();

       
        int allOverScore = midtermScore + finalScore + projectScore + attendanceScore;
        double averageScore = allOverScore / 400.0 * 100; 
        String remarks = (averageScore >= 75) ? "PASSED" : "FAILED";

        
        System.out.println("\nSTUDENT SCORE");
        System.out.println("Midterm Exam Score: " + midtermScore);
        System.out.println("Final Exam Score: " + finalScore);
        System.out.println("Project Score: " + projectScore);
        System.out.println("Attendance Score: " + attendanceScore);
        System.out.printf("\nAverage Score: %.2f\n", averageScore);
        System.out.println("Remarks: " + remarks);

        scanner.close();
    }
}
