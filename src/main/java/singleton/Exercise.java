package singleton;

import java.util.function.Supplier;

class SingletonTester
{
    public static boolean isSingleton(Supplier<Object> func)
    {
        // todo
        Object func1 = func.get();
        Object func2 = func.get();
        return func1 == func2;
    }
}