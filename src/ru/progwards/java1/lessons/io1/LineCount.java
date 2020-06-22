package ru.progwards.java1.lessons.io1;

 /*
    Создать статический метод public static int calcEmpty(String fileName),
    в котором посчитать количество пустых строк в файле. В случае возникновения ошибок, вернуть -1
 */

import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;

public class LineCount {

    public static int calcEmpty(String fileName) {
        int result = 0; //количество строк
        try {
            FileReader reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);

            try {
                while (scanner.hasNextLine()) {
                    String strFromFile = scanner.nextLine();

                    if (strFromFile.length() == 0) {
                        result++;
                    }
                }
            } finally {
                reader.close();
                scanner.close();
            }
            return result;
        } catch (IOException e) {
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(calcEmpty("src\\ru\\progwards\\java1\\lessons\\io1\\H10.1.txt"));
        System.out.println(calcEmpty("src\\ru\\progwards\\java1\\lessons\\io1\\H10,1.txt"));
    }
}