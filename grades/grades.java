import java.util.Scanner;

//Main class for loading up the two interfaces

public class grades {
    public static void main(String[] args) {
    
        AverageUI averageUI = new AverageUI();
        //gets subscribed in Constructor
        GradeUI gradeUI = new GradeUI();
        //gets subscribed in Constructor
        Scanner input = new Scanner(System.in);
        System.out.print("What do you want to do (1. Add Grade, 2. Delete all grades, 3. Quit): ");
        int answer = input.nextInt();
        while (answer != 3) {
            if (answer == 1) {
                System.out.print("Enter Grade: ");
                FileManager.GetInstance().AddGrade(input.nextInt());
            } else {
                System.out.println("Deleting all grades....");
                FileManager.GetInstance().DeleteAllGrades();
                System.out.println("Printing Empty Grades");
                System.out.println(FileManager.GetInstance().GetAllGrades());
                System.out.println("First Grade in File is " + FileManager.GetInstance().GetFirstGrade());
            }
            System.out.print("What do you want to do (1. Add Grade, 2. Delete all grades, 3. Quit): ");
            answer = input.nextInt();
        }
        input.close();
    }
}
