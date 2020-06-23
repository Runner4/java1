package ru.progwards.java1.lessons.io1;

/*
Создать статический метод
public static void codeFile(String inFileName, String outFileName, char[] code, String logName)
, в котором прочитать файл inFileName и перекодировать его посимвольно
в соответствии с заданным шифром, результат записать в outFileName.
Шифр задается маcсивом char[] code, где каждому символу symbol оригинального файла
соответствует символ code[(int)symbol] выходного файла.
В случае ошибок, в файл с именем logName вывести название ошибки через метод класса Exception - getMessage()
*/

import java.io.*;

public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
//        try {
//            //запись ошибок в лог
//            FileWriter error = new FileWriter(logName);
//            //копия файла
//            FileWriter in = new FileWriter(outFileName);
//            try {
//                //чтение
//                FileReader reader = new FileReader(inFileName);
//                Scanner scanner = new Scanner(reader);
//                while (scanner.hasNextLine()) {
//                    String strFromFile = scanner.nextLine();
//                    for (int i = 0; i < strFromFile.length(); i++) {
//                        int a = 0;
//                        for (char value : code) {
//                            a += value;
//                            in.write("" + Integer.valueOf(a) + "\n");   //столбец
//                        }
//                    }
//                }
//                in.close();
//                scanner.close();
//
//            } catch (Exception e) {
//                error.write(e.getMessage());
//                error.close();
//                throw new RuntimeException(e);
//            }
//        } catch (
//                Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
        FileInputStream fIn = null;
        BufferedInputStream bIn = null;
        FileOutputStream fOut = null;
        BufferedOutputStream bOut = null;
        try {
            fIn = new FileInputStream(inFileName);
            bIn = new BufferedInputStream(fIn);
            fOut = new FileOutputStream(outFileName);
            bOut = new BufferedOutputStream(fOut);
            int i;
            while ((i = bIn.read()) != -1) {
                bOut.write(code[i]);
            }
        } catch (Throwable e) {
            FileWriter fEOut = null;
            BufferedWriter bEOut = null;
            try {
                fEOut = new FileWriter(logName, true);
                bEOut = new BufferedWriter(fEOut);
                bEOut.write(e.getMessage());
            } catch (Throwable e2) {
            } finally {
                try {
                    if (bEOut != null) bEOut.close();
                    if (fEOut != null) fEOut.close();
                } catch (Throwable e3) {
                }
            }
        } finally {
            try {
                if (bOut != null) bOut.close();
                if (fOut != null) fOut.close();
                if (bIn != null) bIn.close();
                if (fIn != null) fIn.close();
            } catch (Throwable e) {
            }
        }
    }

    public static void main(String[] args) throws IOException {
        char[] code = new char[256];
        for (int i = 0; i < 256; i++) code[i] = (char) (Character.isDigit((char) i) ? i + 1 : i);
        codeFile("io1.txt", "io1_OutFile.txt", code, "log.txt");
    }
}
