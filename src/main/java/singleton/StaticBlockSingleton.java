package singleton;

import java.io.File;
import java.io.IOException;

public class StaticBlockSingleton {
    private StaticBlockSingleton() throws IOException {
        System.out.println("Singleton is initializing");
        File.createTempFile(".", ".");
    }

    private static StaticBlockSingleton instance;

    // static イニシャライザ
    // クラスがメモリ上にロードされた後に実行される処理
    // 単純代入で初期化できない場合に使われる hashMapなど
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            System.err.println("failed to create singleton");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
