package com.lxl;


public class Test1 {
    public static void main(String[] args) {


        new Test2();
        new Test2();
        new Test2(3);
        new Test2();
        new Test2(5);
        Test2.count();

    }

}
    class Test2 {
        int id;
        String name;
        static int sum = 0;

       static {
            sum += 1;
        }

        Test2() {

        }

        Test2(int id) {

        }

        static void count() {
            System.out.println(sum);
        }

    }




