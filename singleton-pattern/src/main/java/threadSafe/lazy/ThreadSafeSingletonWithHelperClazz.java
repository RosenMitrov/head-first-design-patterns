package threadSafe.lazy;

@SuppressWarnings("InstantiationOfUtilityClass")
class ThreadSafeSingletonWithHelperClazz {

    private ThreadSafeSingletonWithHelperClazz() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static final class InstanceHolder {
        private static final ThreadSafeSingletonWithHelperClazz instance = new ThreadSafeSingletonWithHelperClazz();
    }

    // Returns the singleton instance.
    // Thread-safe and lazily initialized via class loading.
    public static ThreadSafeSingletonWithHelperClazz getInstance() {
        return InstanceHolder.instance;
    }
}

class ThreadSafeAppV2 {
    public static void main(String[] args) {
        Runnable task = () -> {
            ThreadSafeSingletonWithHelperClazz singleton =
                    ThreadSafeSingletonWithHelperClazz.getInstance();

            System.out.println(
                    Thread.currentThread().getName() + "  -> " + singleton.toString() + " -> " + singleton.hashCode()
            );
        };

        for (int i = 0; i < 10; i++) {
            new Thread(task, "NewThreadName:" + i).start();
        }
    }
}