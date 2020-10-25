package ru.progwards.java1.lessons.datetime;

/*
Реализовать класс для ручной профилировки производительности программного кода. Профилировка программного кода -
измерение времени выполнения отдельных фрагментов кода с целью выявления узких мест в производительности.

Реализовать методы
2.1 public static void enterSection(String name) - войти в профилировочную секцию, замерить время входа.

2.2 public static void exitSection(String name) - выйти из профилировочной секции. Замерить время выхода, вычислить
промежуток времени между входом и выходом в миллисекундах.

2.3 public static List<StatisticInfo> getStatisticInfo() - получить профилировочную статистику, отсортировать
по наименованию секции

2.4 Реализовать class StatisticInfo
public String sectionName; - имя секции
public int fullTime - полное время выполнения секции в миллисекундах.
public int selfTime - чистое время выполнения секции в миллисекундах. Для вложенных секций, из времени выполнения
внешней секции нужно вычесть времена выполнения вложенных секций.
public int count - количество вызовов. В случае, если вызовов более одного, fullTime и selfTime содержат суммарное
время выполнения всех вызовов.

Секции могут быть только вложенные, как матрешки, и при этом поддержку рекурсии реализовывать не нужно.
Но каждая секция может встретиться несколько раз.

Например:

enterSection(“1”);
…

for(;;) {
     enterSection(“2”);

        enterSection(“3”);

                 …
        exittSection(“3”);
     …
     exittSection(“2”);

}

     enterSection(“4”);

     …
     exittSection(“4”);
...
exittSection(“1”);

И, допустим, мы получаем, что секция 1 выполнялась 1000 миллисекунд, а секция 2 - 700(суммарно), 3 - 500 (суммарно),
4 - 100, в итоге информация должна получиться такая

name fulltime selftime count

1    1000     200      1

2    700      200      100

3    500      500      100

4    100      100      1

Обратите внимание, что сумма всех selfTime равна максимальному времени выполнения, в данном примере это секция 1.
Какая удобная структура данных для хранения информации в процессе работы - продумать самому.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeMap;

enum TimeMeasureUnits {MILLISECONDS, NANOSECONDS};

class StatisticInfo implements Comparable {
    public String sectionName; // имя секции
    public int fullTime = 0; // полное время выполнения секции в миллисекундах
    public int selfTime = 0; // чистое время выполнения секции в миллисекундах
    public int count = 0; // количество вызовов

    boolean isRun; // выполняется ли секция
    private TimeMeasureUnits timeMeasureUnits; // единицы измерения времени
    private long runStartTime; // время начала
    private List<Insider> runInside; // кто запущен внутри


    StatisticInfo(String sectionName, TimeMeasureUnits timeMeasureUnits) {
        this.sectionName = sectionName;
        this.timeMeasureUnits = timeMeasureUnits;
        runInside = new ArrayList<Insider>();
    }

    // текущее время
    long getTimeNow() {
        switch (timeMeasureUnits) {
            case NANOSECONDS:
                return System.nanoTime();
            default:
                return System.currentTimeMillis();
        }
    }

    // вход в секцию
    void enter() {
        count++;
        if (!isRun) {
            isRun = true;
            runStartTime = getTimeNow();
        }
    }

    // выход из секции
    void exit() {
        if (!isRun) return;
        long timeNow = getTimeNow();
        int newFullTime = fullTime + (int) (timeNow - runStartTime);
        int newSelfTime = actualSelfTime(timeNow);
        runInside.clear();
        isRun = false;
        fullTime = newFullTime;
        selfTime = newSelfTime;
    }

    // собственное время, без подсекций
    int actualSelfTime(long timeNow) {
        if (!isRun) return selfTime;
        int result = selfTime + (int) (timeNow - runStartTime);
        for (Insider i : runInside) {
            result -= i.getInsideTime(timeNow);
        }
        return result;
    }

    // добавить внутреннюю секцию
    void addInsider(StatisticInfo info) {
        if (isRun) {
            runInside.add(new Insider(info, getTimeNow()));
        }
    }

    // удалить внутреннюю секцию
    void removeInsider(StatisticInfo info) {
        if (isRun) {
            long timeNow = getTimeNow();
            ListIterator i = runInside.listIterator();
            while (i.hasNext()) {
                Insider insider = (Insider) i.next();
                if (insider.info == info) {
                    selfTime -= insider.getInsideTime(timeNow);
                    i.remove();
                }
            }
        }
    }

    @Override
    public String toString() {
        return "\n" + sectionName + " total:" + fullTime + " self:" + selfTime + " count:" + count;
    }

    // для сортировки в TreeMap
    @Override
    public int compareTo(Object o) {
        return this.sectionName.compareTo(((StatisticInfo) o).sectionName);
    }


}

class Insider {
    public int selfTime; // чистое время связянной секции на момент создания связи
    StatisticInfo info; // секция, с которой связь

    Insider(StatisticInfo info, long timeNow) {
        this.info = info;
        selfTime = info.actualSelfTime(timeNow);
    }

    int getInsideTime(long timeNow) {
        return info.actualSelfTime(timeNow) - selfTime;
    }
}
public class Profiler {
    static TimeMeasureUnits timeMeasureUnits = TimeMeasureUnits.MILLISECONDS;
    static TreeMap<String, StatisticInfo> sections = new TreeMap<String, StatisticInfo>();

    // войти в профилировочную секцию
    public static void enterSection(String name) {
        StatisticInfo section;
        if (sections.containsKey(name)) {
            section = sections.get(name);
        } else {
            section = new StatisticInfo(name, timeMeasureUnits);
            sections.put(name, section);
        }
        if (!section.isRun) {
            for (StatisticInfo i : sections.values()) i.addInsider(section);
        }
        section.enter();
    }

    // выйти из профилировочной секции
    public static void exitSection(String name) {
        StatisticInfo section = sections.get(name);
        section.exit();
        if (!section.isRun) {
            for (StatisticInfo i : sections.values()) i.removeInsider(section);
        }
    }

    // обнулить статистику
    public static void clear() {
        sections.clear();
    }

    // получить профилировочную статистику, отсортировать по наименованию секции
    public static List<StatisticInfo> getStatisticInfo() {
        return new ArrayList<StatisticInfo>(sections.values());
    }

    public static String getSectionsInfo() {
        return sections.values().toString();
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
        }
    }

    public static void main(String[] args) {

        enterSection("s1");
        sleep(100);
        enterSection("s2");
        sleep(200);
        exitSection("s2");
        enterSection("s2");
        sleep(200);
        exitSection("s2");
        enterSection("s2");
        sleep(200);
        exitSection("s2");
        sleep(100);
        exitSection("s1");
        System.out.println(getSectionsInfo());
    }
}