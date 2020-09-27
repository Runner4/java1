package ru.progwards.java1.lessons.queues;

import java.util.*;
import static java.util.Collections.*;

public class CollectionsSort {

    /*    Сравнение методов сортировки коллекций
    1.1 Реализовать метод public static void mySort(Collection<Integer> data) - переделать алгоритм
    из класса ArraySort из ДЗ про массивы, на коллекции. Не использовать встроенные методы сортировок
    1.2 Реализовать метод public static void minSort(Collection<Integer> data) по следующему алгоритму
    - создать новую коллекцию
    - найти минимальный элемент с использованием функции min()
    - переместить его в новую коллекцию
    - делать так до тех пор, пока все элементы не окажутся в новой коллекции
    - скопировать новую коллекцию в старую
    1.3 Реализовать метод public static void collSort(Collection<Integer> data) используя метод sort из Collections
    1.4 Реализовать метод public static Collection<String> compareSort() в котором сравнить производительность
    методов и вернуть их имена, отсортированные в порядке производительности, первый - самый быстрый. В случае
    равенства производительности первым вернуть "collSort".
    */

    public static void mySort(Collection<Integer> data){
        ArrayList<Integer> arrayList = new ArrayList(data);

        for (int i=0; i<arrayList.size() ; i++){
            for (int j=i+1 ; j<arrayList.size(); j++){
                if(arrayList.get(i) > arrayList.get(j)){
                    Collections.swap(arrayList,i,j);
                }
            }
        }
        data.clear();
        data.addAll(arrayList);
        //System.out.println(data);
    }

    public static void minSort(Collection<Integer> data) {
        ArrayList<Integer> arrayList = new ArrayList();

        while (!data.isEmpty()){
            arrayList.add(min(data));
            data.remove(min(data));
        }
        data.addAll(arrayList);

    }

    public static void collSort(Collection<Integer> data){

        List<Integer> linkedList = new LinkedList<>(data);
        Collections.sort(linkedList);
        data.clear();
        data.addAll(linkedList);
    }

    public static Collection<String> compareSort(){
        List<String> rezult = new LinkedList<>();
        final int ELEM_COUNT = 1_000;
        List<Integer> collection = new ArrayList<>();
        for (int i = 0; i < ELEM_COUNT; i++) collection.add(ELEM_COUNT - i);
        List<Integer> collection1 = new ArrayList<>();
        for (int i = 0; i < ELEM_COUNT; i++) collection1.add(ELEM_COUNT - i);
        List<Integer> collection2 = new ArrayList<>();
        for (int i = 0; i < ELEM_COUNT; i++) collection2.add(ELEM_COUNT - i);

        long start = System.currentTimeMillis();
        mySort(collection);
        long rezult1 = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        minSort(collection1);
        long rezult2 = System.currentTimeMillis() - start;
        System.out.println("1- "+collection);

        start = System.currentTimeMillis();
        collSort(collection2);
        long rezult3 = System.currentTimeMillis() - start;


        System.out.println("2- "+collection);
        if( rezult1 >= rezult1 && rezult1 >= rezult3){
            rezult.add(0,"collSort");//0
            rezult.add(1,"minSort");//1
            rezult.add(2,"mySort");//2


        } else if( rezult3 >= rezult1 && rezult1 >= rezult2){
            rezult.add(0,"mySort");//2
            rezult.add(1,"collSort");//0
            rezult.add(2,"minSort");//1
        } else {

            rezult.add(0,"mySort");//2
            rezult.add(1,"minSort");//1
            rezult.add(2,"collSort");//0
        }


        return rezult;
    }

    public static void main(String[] args) {
        List<Integer> collection = new ArrayList<>(List.of(3, 5, 9, 12, 1, 2, 158, 33));

        System.out.println();
        mySort(collection);
        collSort(collection);

        System.out.println(compareSort());
    }
}
