//class for the average UI

public class AverageUI extends UI{

    private static int Average;
    private static int gradesTotal;
    
    public AverageUI() {
        FileManager.GetInstance().registerObserver(this);
    }
    public void update() {
        System.out.println();
        System.out.println("      Average Grade UI");
        System.out.println("----------------------------");
        gradesTotal = 0;
        for (int i = 0; i < FileManager.GetInstance().grades.size(); i++) {
            gradesTotal += FileManager.GetInstance().grades.get(i).intValue();
        }
        if (FileManager.GetInstance().grades.size() > 0) {
            Average = gradesTotal / FileManager.GetInstance().grades.size();
            System.out.println("The Average of the grades is " + Average);
        } else {
            System.out.println("No grades in List");
        }
        System.out.println();
    }
    
    @Override
    public void unsubscribe() {
        FileManager.GetInstance().deleteObserver(this);
    }
}
