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
        notifyAll(); // inform threads in wait list that state is changed and they can be going to runnable
    }

    public synchronized void withdraw(String name, double amt) {
        System.out.println(name + " trying to withdraw : " + amt);
        System.out.println(name + " getting balance");
        int count = 0;
        while(getBalance() < amt) {
            count++;
            System.out.println("Insufficient Balance : " + getBalance());
            if(count >= 3) {
                System.out.println("Transaction Failed!!");
                return;
            }
            try {
                wait(15000); // thread goes to wait state by releasing the lock
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        double bal = getBalance();
        System.out.println(name + " got balance :" + bal);

        System.out.println(name + " setting balance ");
        bal -= amt;
        setBalance(bal);
        System.out.println(name + " modifes balance !!!" + bal);
    }
}
