//Connor Smith
//threads.java
//Class to read from a file and use multithreading or singlethreading 
//use command line args to read line by line and see the occurances the word occurs

import java.util.Scanner;
import java.util.regex.*;
import java.io.File;

public class threads {
    public static void main(String[] args) {
        if (args[0].toLowerCase().equals("s")) {
            int words = args.length - 1;
            for (int i = 0; i < words; i++) {
                File file = new File("bible.txt");
                try {
                    Scanner scanner = new Scanner(file);
                    int linecounter = 0;
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine().toLowerCase();
                        Pattern p = Pattern.compile("\\b" + args[1 + i].toLowerCase() + "\\b");
                        Matcher m = p.matcher(line);
                        if (m.find() == true) {
                            linecounter++;
                        }
                    }
                    System.out.println("Found " + linecounter + " lines that contain " + args[1 + i]);
                    scanner.close();
                } catch (Exception e) {
                    System.out.println("Error reading from bible.txt");
                }
            }
        } else {
            int words = args.length - 1;
            for (int i = 0; i < words; i++) {
                MyThread object = new MyThread(args[1 + i]);
                object.start();
            }
        }
    }
}
