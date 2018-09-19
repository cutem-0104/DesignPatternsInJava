package singleton;

public class InnerStaticSingleton {
    private InnerStaticSingleton() {}

    public static class Impl {
        private static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();
    }

    public InnerStaticSingleton getInstance() {
        return Impl.INSTANCE;
    }
}
