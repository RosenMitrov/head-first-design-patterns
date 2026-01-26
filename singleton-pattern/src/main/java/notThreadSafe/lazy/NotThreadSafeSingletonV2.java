package notThreadSafe.lazy;

@SuppressWarnings("InstantiationOfUtilityClass")
class NotThreadSafeSingletonV2 {

    private static NotThreadSafeSingletonV2 instance;

    private NotThreadSafeSingletonV2() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static NotThreadSafeSingletonV2 getInstance() {
        if (instance == null) {
            //more than one thread could step in here
            synchronized (NotThreadSafeSingletonV2.class) {
                instance = new NotThreadSafeSingletonV2();
            }
        }
        return instance;
    }
}


class NotThreadSafeAppV2 {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            NotThreadSafeSingletonV2 singleton = NotThreadSafeSingletonV2.getInstance();
            System.out.println(
                    Thread.currentThread().getName() + "  -> " + singleton.toString() + " -> " + singleton.hashCode()
            );
        };


        for (int i = 0; i < 10; i++) {
            new Thread(runnable, "MyThread:" + i).start();
        }

    }
}
