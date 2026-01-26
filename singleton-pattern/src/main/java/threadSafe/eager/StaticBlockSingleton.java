package threadSafe.eager;

@SuppressWarnings("InstantiationOfUtilityClass")
public class StaticBlockSingleton {

    private static final StaticBlockSingleton INSTANCE;

    static {
        try {
            INSTANCE = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create singleton", e);
        }
    }

    private StaticBlockSingleton() {}

    public static StaticBlockSingleton getInstance() {
        return INSTANCE;
    }
}


class ThreadSafeAppV2 {
    public static void main(String[] args) {
        Runnable task = () -> {
            StaticBlockSingleton singleton =
                    StaticBlockSingleton.getInstance();

            System.out.println(
                    Thread.currentThread().getName() + "  -> " + singleton + " -> " + singleton.hashCode()
            );
        };

        for (int i = 0; i < 10; i++) {
            new Thread(task, "NewThreadName:" + i).start();
        }
    }
}