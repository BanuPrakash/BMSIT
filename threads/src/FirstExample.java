public class FirstExample {
    public static void main(String[] args) {
        System.out.println("Main Starts");
            doTask();

        System.out.println("Main Ends!!1");
    }

    private static void doTask() {
       Thread t =  Thread.currentThread(); // gives reference to the Thread on whose Stack this method is pushed
        System.out.println("Name: " + t.getName());
        System.out.println("Priority : " + t.getPriority());
        System.out.println("Group : " + t.getThreadGroup().getName());
    }
}
