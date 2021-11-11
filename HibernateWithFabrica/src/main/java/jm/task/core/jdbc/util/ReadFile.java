package jm.task.core.jdbc.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

    public static String read() {
        String d = "";
        try {
            File file = new File("D:\\java education\\Hibernate\\src\\main\\resources\\properties.txt");

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                d = scanner.nextLine();

            }
            scanner.close();


        }catch (FileNotFoundException e){
            System.out.println("error");
            e.printStackTrace();
        }
        return d;
    }
}
