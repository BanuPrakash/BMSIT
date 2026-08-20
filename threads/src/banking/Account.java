package banking;

public class Account {
    private double balance; // instance variable, not thread safe
    private String name;

    public Account(String name, double balance) {
        this.balance = balance;
        this.name = name;
    }

    public double getBalance() {
        try {
            Thread.sleep((long) (Math.random() * 2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return balance;
    }

    private void setBalance(double balance) {
        try {
            Thread.sleep((long) (Math.random() * 2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.balance = balance;
    }

    // Mutex, Monitor, Lock
    public synchronized  void deposit(String name, double amt) {
        System.out.println(name + " trying to deposit : " + amt);
        System.out.println(name + " getting balance");
        double bal = getBalance();
        System.out.println(name + " setting balance ");
        bal += amt;
        setBalance(bal);
        System.out.println(name + " modifes balance !!!" + bal);
    }

    public synchronized void withdraw(String name, double amt) {
        System.out.println(name + " trying to withdraw : " + amt);
        System.out.println(name + " getting balance");
        double bal = getBalance();
        System.out.println(name + " setting balance ");
        bal -= amt;
        setBalance(bal);
        System.out.println(name + " modifes balance !!!" + bal);
    }
}
