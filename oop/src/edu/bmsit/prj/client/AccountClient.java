package edu.bmsit.prj.client;


import edu.bmsit.prj.entity.Account;

// standalone client
public class AccountClient {
    public static void main(String[] args) {
        Account rahulAcc = new Account(); // instance -- keyword is "new" similar to malloc / calloc of "C" - DMA
        Account swethaAcc = new Account(500); // instance

        rahulAcc.deposit(2500);
        swethaAcc.deposit(5600);

        System.out.println("Rahul Account");
        System.out.println("Balance : " + rahulAcc.getBalance());

        System.out.println("Swetha Account");
        System.out.println("Balance : " + swethaAcc.getBalance());

        System.out.println("Count :" + Account.getCount()); // 200
    }
}
