//Class for the individual grades UI

public class GradeUI extends UI {

    public GradeUI() {
        FileManager.GetInstance().registerObserver(this);
    }

    public void update() {
        System.out.println("           GradesUI");
        System.out.println("---------------------------------");
        if (FileManager.GetInstance().grades.size() > 0) {
            System.out.println("New grades are as Follow: ");
            System.out.println(FileManager.GetInstance().GetAllGrades());
        } else {
            System.out.println("NO GRADES IN LIST");
        }
        System.out.println();
    }

    @Override
    public void unsubscribe() {
        FileManager.GetInstance().deleteObserver(this);
    }
    
}
