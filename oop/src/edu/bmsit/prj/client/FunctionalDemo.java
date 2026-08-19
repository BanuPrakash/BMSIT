package edu.bmsit.prj.client;

import edu.bmsit.prj.util.Computation;

public class FunctionalDemo {
    public static void main(String[] args) {
        // Anonymous class
       Computation c1 = new Computation() {
           @Override
           public int compute(int x, int y) {
               return x + y;
           }
       } ;

       System.out.println(c1.compute(5,3));

       // Lambda expression
       Computation c2 = (int x, int y) -> {
           return x * y;
        };

        System.out.println(c2.compute(5,4));

        // Lambda expression
       Computation c3 = (x, y) -> x /y;

        System.out.println(c3.compute(10, 2));


    }


}
