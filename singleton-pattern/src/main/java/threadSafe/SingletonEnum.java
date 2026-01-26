package threadSafe;

public enum SingletonEnum {
    INSTANCE
}

class ThreadSafeAppV3 {
    public static void main(String[] args) {
        Runnable task = () -> {
            SingletonEnum singleton =
                    SingletonEnum.INSTANCE;

            System.out.println(
                    Thread.currentThread().getName() + "  -> " + singleton + " -> " + singleton.hashCode()
            );
        };

        for (int i = 0; i < 10; i++) {
            new Thread(task, "NewThreadName:" + i).start();
        }
    }
}

//If we compare first-access creation, SingletonEnum and double-checked(DCL) Singleton are both effectively LAZY.
// The distinction is theoretical:
// -    ENUM initialization is tied to JVM class loading,
// -    While DCL is tied to the accessor method.