//class for what the thread to do

import java.io.File;
import java.util.Scanner;
import java.util.regex.*;

public class MyThread extends Thread {
    
    private String keyword;

    public MyThread(String keyword) {
        this.keyword = keyword;
    }

    public void run() {
        try {
            File file = new File("bible.txt");
            Scanner scanner = new Scanner(file);
            int linecounter = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase();
                Pattern p = Pattern.compile("\\b" + keyword.toLowerCase() + "\\b");
                Matcher m = p.matcher(line);
                if (m.find() == true) {
                    linecounter++;
                }
            }
            System.out.println("Found " + linecounter + " lines that contain " + keyword);
            scanner.close();
        } catch (Exception e) {
            System.out.println("Exception trying to do multithreading");
        }
    }
}
