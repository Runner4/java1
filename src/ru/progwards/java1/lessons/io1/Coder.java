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

        FileInputStream fInStr = null;
        BufferedInputStream bInStr = null;
        FileOutputStream fOutStr = null;
        BufferedOutputStream bOutStr = null;
        try {
            fInStr = new FileInputStream(inFileName);
            bInStr = new BufferedInputStream(fInStr);
            fOutStr = new FileOutputStream(outFileName);
            bOutStr = new BufferedOutputStream(fOutStr);
            int i;
            while ((i = bInStr.read()) != -1) {
                bOutStr.write(code[i]);
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
                if (bOutStr != null) bOutStr.close();
                if (fOutStr != null) fOutStr.close();
                if (bInStr != null) bInStr.close();
                if (fInStr != null) fInStr.close();
            } catch (Throwable e) {
            }
        }
    }

    public static void main(String[] args) {
        char[] code = new char[256];
        for (int i = 0; i < 256; i++) code[i] = (char) (Character.isDigit((char) i) ? i + 1 : i);
        codeFile("src\\ru\\progwards\\java1\\lessons\\io1\\Coder1.java",
                "src\\ru\\progwards\\java1\\lessons\\io1\\Coder.txt",
                code,
                "src\\ru\\progwards\\java1\\lessons\\io1\\Coder.log");    }
}
