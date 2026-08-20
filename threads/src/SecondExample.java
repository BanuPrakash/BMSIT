public class SecondExample {
    public static void main(String[] args) {
        NumberThread t1 = new NumberThread(1, 200);
        NumberThread t2 = new NumberThread(500, 900);
        t2.setDaemon(true);  // application will not wait for t2 to finish
        t1.start();
        t2.start(); // 3 threads are in ready state / runnable state

        CharRunnable ch = new CharRunnable();
//        ch.run(); // it runs on main Thread

//        Thread t3 = new Thread();
//        t3.start(); // default run() is pushed on stack, nothing to execute, it dies

        Thread t3 = new Thread(ch);
        t3.start();
        System.out.println("Main Dies!!!");
    }
}
