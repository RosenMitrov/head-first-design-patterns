package threadSafe.lazy;

@SuppressWarnings("InstantiationOfUtilityClass")
class ThreadSafeSingletonSynchronizedMethod {

    private static ThreadSafeSingletonSynchronizedMethod instance;

    private ThreadSafeSingletonSynchronizedMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Method below is synchronized and visible to all threads
    public static synchronized ThreadSafeSingletonSynchronizedMethod getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingletonSynchronizedMethod();
        }
        return instance;
    }
}

class ThreadSafeAppV3 {
    public static void main(String[] args) {
        Runnable task = () -> {
            ThreadSafeSingletonSynchronizedMethod singleton =
                    ThreadSafeSingletonSynchronizedMethod.getInstance();

            System.out.println(
                    Thread.currentThread().getName() + "  -> " + singleton.toString() + " -> " + singleton.hashCode()
            );
        };


        for (int i = 0; i < 10; i++) {
            new Thread(task, "NewThreadName:" + i).start();
        }
    }
}