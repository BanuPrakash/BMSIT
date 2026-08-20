package banking;

public class BankingApplication {
    public static void main(String[] args) {
        Account account = new Account("SB123", 5000);

        TransactionThread t1 = new TransactionThread(account, TransactionType.CREDIT, "Peter", 2500.00);
        TransactionThread t2 = new TransactionThread(account, TransactionType.DEBIT, "\tRoger", 9000.00);
        TransactionThread t3 = new TransactionThread(account, TransactionType.CREDIT, "\t\tRita", 2000.00);


        t2.start(); // main t1 and t2 are ready
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t1.start(); // main and t1 are ready

        t3.start();// main t1, t2 and t3 are ready [ 4 stacks ]

        // Barrier
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final Balance : " + account.getBalance());
    }
}
