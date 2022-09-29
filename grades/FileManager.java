import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//The class that acts as the Singleton Instance File

public class FileManager {
    private static FileManager OnlyInstance = null;
    private static File file = new File ("Grades.txt");
    ArrayList<Integer> grades = new ArrayList<>();
    ArrayList<UI> observers = new ArrayList<>();

    private FileManager() {
        try {
            if(file == null || !file.exists()) {
                file = new File("Grades.txt");
            } else {
                Scanner scanner = new Scanner(file);
                while(scanner.hasNext()) {
                    grades.add(scanner.nextInt());
                }
                scanner.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public synchronized static FileManager GetInstance() {
        if (OnlyInstance == null) {
            OnlyInstance = new FileManager();
        }
        return OnlyInstance;
    }

    public void registerObserver(UI ui) {
        observers.add(ui);
    }

    public void deleteObserver(UI ui) {
        observers.remove(ui);
    }

    public void AddGrade(int grade) {
        grades.add(grade);
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < grades.size(); i ++) {
                bw.write(grades.get(i).toString() + "\n");
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            System.out.println("Error Adding grade to File");
        }
        notifyObservers();
    }

    public Integer GetFirstGrade() {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    grades.add(scanner.nextInt());
                }
            }
            scanner.close();
            Integer FirstGrade = grades.get(0);
            if (FirstGrade == null) {
                return null;
            } else {
                return FirstGrade;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Integer> GetAllGrades() {
        return grades;
    }

    public void DeleteAllGrades() {
        grades.clear();
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < grades.size(); i ++) {
                bw.write(grades.get(i).toString() + "\n");
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error deleting all grades from file");
        }
        notifyObservers();
    }

    private void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update();
        }
    }
}

