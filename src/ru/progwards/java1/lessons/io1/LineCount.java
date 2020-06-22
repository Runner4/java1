package ru.progwards.java1.lessons.io1;

 /*
    Создать статический метод public static int calcEmpty(String fileName),
    в котором посчитать количество пустых строк в файле. В случае возникновения ошибок, вернуть -1
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LineCount {

    public static int calcEmpty(String fileName) {
        int count = 0; //подсчет строк
        try {
            FileReader reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);

            try {
                while (scanner.hasNextLine()) {
                    String strFromFile = scanner.nextLine();

                    if (strFromFile.length() == 0) {
                        count++;
                    }
                }
            } finally {
                reader.close();
                scanner.close();
            }
            return count;
        } catch (IOException e) {
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(calcEmpty("src\\test.txt"));
    }
//        int result = 0;
//        int resultOnError = -1;
//        String searchString = "";
//
//        try (FileReader f = new FileReader(fileName); Scanner s = new Scanner(f)) {
//            while (s.hasNextLine()) {
//                String str = s.nextLine();
//                if (str.compareTo(searchString) == 0) result++;
//            }
//        } catch (FileNotFoundException e) {
//            result = resultOnError;
//        } catch (IOException e) {
//            result = resultOnError;
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(calcEmpty("java1.iml"));
//        System.out.println(calcEmpty("java1-.iml"));
//    }
}
