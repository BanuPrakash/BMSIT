public class Second {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Boom :-( " + t.getName() + " had problem : " + e.getMessage());
            }
        });
        System.out.println("Main Enters");
        doTask();
        System.out.println("Main Exits!!!");
    }

    private static void doTask() {
        int x = 10;
        int y = 0;
        int result = x / y;
        System.out.println("Result :" + result);
    }
}
