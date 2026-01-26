package threadSafe.lazy;

@SuppressWarnings("InstantiationOfUtilityClass")
class ThreadSafeSingletonDoubleChecked {

    private volatile static ThreadSafeSingletonDoubleChecked instance;

    private ThreadSafeSingletonDoubleChecked() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Double-checked synchronization
    public static ThreadSafeSingletonDoubleChecked getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingletonDoubleChecked.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingletonDoubleChecked();
                }
            }
        }
        return instance;
    }
}

class ThreadSafeAppV1 {
    public static void main(String[] args) {
        Runnable task = () -> {
            ThreadSafeSingletonDoubleChecked singleton =
                    ThreadSafeSingletonDoubleChecked.getInstance();

            System.out.println(
                    Thread.currentThread().getName() + "  -> " + singleton.toString() + " -> " + singleton.hashCode()
            );
        };

        for (int i = 0; i < 10; i++) {
            new Thread(task, "NewThreadName:" + i).start();
        }
    }
}