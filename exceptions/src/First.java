public class First {
    public static void main(String[] args) {
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
