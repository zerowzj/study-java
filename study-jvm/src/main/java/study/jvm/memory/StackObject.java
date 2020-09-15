package study.jvm.memory;

public class StackObject {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public void keepRunning() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            new Thread(() -> {
                keepRunning();
            }).start();
        }
    }
}
