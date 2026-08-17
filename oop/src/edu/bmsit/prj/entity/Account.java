package edu.bmsit.prj.entity;

public class Account {
    // always make state as private
    private double balance; // state, instance variables
    private static int count; // class member

    // default
    public  Account(){
        count++;
        this.balance = 0.0;
    }

    // parametrized constructor
    public Account(double intValue){
        count++;
        this.balance += intValue;
    }
    // actions, messages, behaviour --> instance methods
    public void deposit(double amt) {
        this.balance += amt;
    }

    public void withdraw(double amt) {
        this.balance -= amt;
    }

    public double getBalance() {
        return  this.balance;
    }

    // class method
    public static int getCount() {
        return  count;
    }
}
