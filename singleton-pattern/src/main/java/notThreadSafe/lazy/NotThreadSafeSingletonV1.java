package notThreadSafe.lazy;

@SuppressWarnings("InstantiationOfUtilityClass")
class NotThreadSafeSingletonV1 {

    private static NotThreadSafeSingletonV1 instance;

    private NotThreadSafeSingletonV1() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static NotThreadSafeSingletonV1 getInstance() {
        if (instance == null) {
            //more than one thread could step in here
            instance = new NotThreadSafeSingletonV1();
        }
        return instance;
    }
}


class NotThreadSafeAppV1 {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            NotThreadSafeSingletonV1 singleton = NotThreadSafeSingletonV1.getInstance();
            System.out.println(
                    Thread.currentThread().getName() + "  -> " + singleton.toString() + " -> " + singleton.hashCode()
            );
        };


        for (int i = 0; i < 10; i++) {
            new Thread(runnable, "MyThread:" + i).start();
        }

    }
}
