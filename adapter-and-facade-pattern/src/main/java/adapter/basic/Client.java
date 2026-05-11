package adapter.basic;

public class Client {
    public static void main(String[] args) {
        Adaptee adapteeSpecific = new AdapteeSpecific();
        Adapter adapter = new Adapter(adapteeSpecific);

        adapter.executeTarget();
    }
}
