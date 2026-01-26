package threadSafe.eager;

@SuppressWarnings("InstantiationOfUtilityClass")
public class EagerSingleton {

    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}


class ThreadSafeAppV1 {
    public static void main(String[] args) {
        Runnable task = () -> {
            EagerSingleton singleton =
                    EagerSingleton.getInstance();

            System.out.println(
                    Thread.currentThread().getName() + "  -> " + singleton + " -> " + singleton.hashCode()
            );
        };

        for (int i = 0; i < 10; i++) {
            new Thread(task, "NewThreadName:" + i).start();
        }
    }
}