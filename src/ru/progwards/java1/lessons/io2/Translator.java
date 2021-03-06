package ru.progwards.java1.lessons.io2;

//public class Translator {
    /*Создать класс Translator - переводчик, который будет переводить предложения с одного языка на другой.

      Конструктор Translator(String[] inLang, String[] outLang), где inLang и outLang - массивы слов на разных языках,
      например русском и английском. Сохранить значения параметров в приватных свойствах класса.

      Метод public String translate(String sentence), в котором найти слова, содержащиеся в sentence и в inLang и
      заменить их на соответствующие в outLang. Пунктуация должна быть соблюдена (скопирована из оригинальной строки).
      При этом надо соблюсти заглавные буквы, если они были в оригинальном тексте.
      В inLang и outLang все слова хранятся в нижнем регистре.

      Например, фраза "Hello World!" будет переведена как "Привет Мир!"
      при наличии слов "hello", "world" в inLang и "привет", "мир" в outLang
    */
//    private class Translation {
//        String wordFrom;
//        String wordTo;
//    }
//
//    //String[] inLang; // "с какого языка переводим", в нижнем регистре
//    //String[] outLang; // "на какой язык переводим", в нижнем регистре
//    Hashtable<String, String> wordTable; // атры слов в хэш-таблице
//
//    Translator(String[] inLang, String[] outLang) {
//        //this.inLang = inLang;
//        //this.outLang = outLang;
//        if (outLang.length != inLang.length) throw new ArrayIndexOutOfBoundsException("Длины массивов должны быть одинаковы");
//
//        int count = inLang.length;
//        wordTable = new Hashtable<String, String>(count);
//        for (int i = 0; i < count; i++) {
//            wordTable.put(inLang[i].toLowerCase(), outLang[i].toLowerCase());
//        }
//    }
//
//    public String translateWord(String word) {
//        String result = wordTable.get(word.toLowerCase());
//        if (result == null) return word;
//        if (Character.isUpperCase(word.charAt(0))) {
//            return Character.toUpperCase(result.charAt(0)) + (result.length() > 1 ? result.substring(1) : "");
//        }
//        return result;
//    }
//
//    public String translate(String sentence) {
//        StringBuilder result = new StringBuilder(128);
//        int wordBeginIndex = -1;
//        int len = sentence.length();
//
//        for(int i = 0; i < len; i++) {
//            char c = sentence.charAt(i);
//            if (Character.isLetter(c)) {
//                if (wordBeginIndex < 0) wordBeginIndex = i;
//            } else {
//                if (wordBeginIndex >= 0) {
//                    result.append(translateWord(sentence.substring(wordBeginIndex, i)));
//                    wordBeginIndex = -1;
//                }
//                result.append(c);
//            }
//        }
//        if (wordBeginIndex >= 0) {
//            result.append(translateWord(sentence.substring(wordBeginIndex)));
//        }
//        return result.toString();
//    }
//
//    public static void main(String[] args) {
//        String[] inLang = {"привет", "мир", "как", "твои", "дела"};
//        String[] outLang = {"hello", "world", "how", "your", "deals"};
//        Translator t = new Translator(inLang, outLang);
//        System.out.println(t.translate("Привет, Мир!"));
//
////        Translator t = new Translator(new String[]{"puck"}, new String[]{"****"});
////        System.out.println(t.translate("What the puck are you shooting?"));
//    }
//}

    public class Translator {

        private String[] inLang, outLang;

        public Translator(String[] inLang, String[] outLang) {
            this.inLang = inLang;
            this.outLang = outLang;
        }

        public String translate(String sentence) {
            StringBuilder sb = new StringBuilder();
            String[] words = sentence.split(" ");
            for (int i = 0; i < words.length; i++) {
                boolean isExists = false;
                for (int j = 0; j < inLang.length; j++) {
                    if (words[i].toLowerCase().contains(inLang[j])) {
                        String out_word = "";
                        if (Character.isUpperCase(words[i].charAt(0))) {
                            out_word = Character.toString(Character.toUpperCase( outLang[j].charAt(0)));
                            out_word +=(outLang[j].substring(1));
                        } else  {
                            out_word = (outLang[j]);
                        }
                        sb.append(words[i].toLowerCase().replace(inLang[j],out_word));
                        if (i != words.length-1) {
                            sb.append(" ");
                        }
                        isExists = true;
                    }
                }
                if (!isExists) {
                    sb.append(words[i]);
                    sb.append(" ");
                }
            }
            return sb.toString();
        }

        public static void main(String[] args) {
            Translator translator = new Translator(new String[] {"make", "love", "not", "war"}
                    , new String[] {"твори", "любовь", "не", "войну" });
            System.out.println(translator.translate("Not war - love make!"));

        }
    }