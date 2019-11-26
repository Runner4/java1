package ru.progwards.pvv;

public class Test3_3 {
    static long factorial(long n){
        long fact = 1L;
        if (n!=0L) {
            for (long c = 1L; c<=n; c++){
                fact *=c;
            }
        } else {
            fact = 1L;
        }
        return fact;
    }
    //  static long factorial (long num) {
  //      return (num == 0) ? 1 : num * factorial (num - 1);
  //  }
    public static void main(String[] args) {
        System.out.println(factorial(3));
    }
}
