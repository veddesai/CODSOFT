//Task 2 : Student Grade Calculator ---- JAVA Developer Internship (CODSOFT)

import java.util.Scanner;
public class StudentGradeCalculator {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int numSubjects = getNumberOfSubjects(scanner);
            int[] marks = getMarks(scanner, numSubjects);

            int totalMarks = calculateTotalMarks(marks);
            double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);
            String grade = determineGrade(averagePercentage);

            displayResults(totalMarks, averagePercentage, grade);
        }

        public static int getNumberOfSubjects(Scanner scanner) {
            System.out.print("Enter the number of subjects: ");
            return scanner.nextInt();
        }

        public static int[] getMarks(Scanner scanner, int numSubjects) {
            int[] marks = new int[numSubjects];
            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                marks[i] = scanner.nextInt();

                 if (marks[i] < 0 || marks[i] > 100) {
                     System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                     i--; // Re-enter marks for invalid input
                 }
            }
            return marks;
        }

        public static int calculateTotalMarks(int[] marks) {
            int total = 0;
            for (int mark : marks) {
                total += mark;
            }
            return total;
        }

        public static double calculateAveragePercentage(int totalMarks, int numSubjects) {
            return (double) totalMarks / numSubjects ;
        }

        public static String determineGrade(double averagePercentage) {
            String grade;
            if (averagePercentage >= 90) {
                grade = "A";
            } else if (averagePercentage >= 80) {
                grade = "B";
            } else if (averagePercentage >= 70) {
                grade = "C";
            } else if (averagePercentage >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }
            return grade;
        }

        public static void displayResults(int totalMarks, double averagePercentage, String grade) {
            System.out.println("\nTotal Marks: " + totalMarks);
            System.out.printf("Average Percentage: %.2f%%\n", averagePercentage); // Format percentage with 2 decimal places
            System.out.println("Grade: " + grade);
        }
    }


