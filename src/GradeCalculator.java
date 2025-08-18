public class GradeCalculator {
    public double calculateAverage(double... grades) {
        if (grades == null || grades.length == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    public String getLetterGrade(double average) {
        if (average >= 90.0 && average <= 100.0) {
            return "A";
        } else if (average >= 80.0 && average < 90.0) {
            return "B";
        } else if (average >= 70.0 && average < 80.0) {
            return "C";
        } else if (average >= 60.0 && average < 70.0) {
            return "D";
        } else {
            return "F";
        }
    }


    public void displayResult(String studentName, double average) {
        System.out.printf("Student: %s | Average: %.2f%n", studentName, average);
    }


    public void displayResult(String studentName, double average, String letterGrade) {
        System.out.printf("Student: %s | Average: %.2f | Letter Grade: %s%n", studentName, average, letterGrade);
    }


    public static void main(String[] args) {
        GradeCalculator calculator = new GradeCalculator();

        String studentName = "John Smith";
        double[] grades = {85.5, 92.0, 78.5, 90.0};

        double average = calculator.calculateAverage(grades);
        String letterGrade = calculator.getLetterGrade(average);


        calculator.displayResult(studentName, average);


        calculator.displayResult(studentName, average, letterGrade);
    }
}
