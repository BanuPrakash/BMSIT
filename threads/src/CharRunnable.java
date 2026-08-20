public class CharRunnable implements  Runnable {

    @Override
    public void run() {
        printChars();
    }

    private void printChars() {
        Thread t = Thread.currentThread();
        for(int i = 'A'; i <= 'z'; i++) {
            System.out.println(t.getName() + " : " + (char) i);
        }
    }
}
