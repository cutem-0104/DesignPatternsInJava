package singleton;

// https://google.github.io/guava/releases/21.0/api/docs/com/google/common/collect/Iterables.html
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Iterables;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.*;

interface Database {
    int getPopulation(String name);
}

public class SingletoDatabase implements Database{
    private Dictionary<String, Integer> capitals = new Hashtable<>();
    private static int instanceCount = 0;
    public static int getCount() { return instanceCount; }

    private SingletoDatabase() {
        instanceCount++;
        System.out.println("Initializing database");

        try {
            // クラスの絶対パスを取得する
            File f = new File(SingletoDatabase.class.getProtectionDomain()
                    .getCodeSource().getLocation().getPath());
            Path fullPath = Paths.get(f.getPath(), "capitals.txt");
            List<String> lines = Files.readAllLines(fullPath);
//            lines.forEach(System.out::println);

            // イテラブルを指定されたサイズの変更不可能なサブリストに分割します
            // （最終的な反復可能性はより低いかもしれません）。
            Iterables.partition(lines, 2).forEach(System.out::println);
            Iterables.partition(lines, 2)
                    .forEach(kv -> capitals.put(
                            kv.get(0).trim(),
                            Integer.parseInt(kv.get(1))
                    ));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final SingletoDatabase INSTANCE = new SingletoDatabase();

    public static SingletoDatabase getInstance() {
        return INSTANCE;
    }

    public int getPopulation(String name) {
        return capitals.get(name);
    }
}

class SingletonRecordFinder {
    public int getTotalPopulation(List<String> names) {
        int result = 0;
        for (String name : names) {
            result += SingletoDatabase.getInstance().getPopulation(name);
        }
        return result;
    }
}

class ConfigurableRecordFinder {
    private Database database;

    public ConfigurableRecordFinder(Database database) {
        this.database = database;
    }

    public int getTotalPopulation(List<String> names) {
        int result = 0;
        for (String name : names) {
            result += database.getPopulation(name);
        }
        return result;
    }
}

class DummyDatabase implements Database {
    private Dictionary<String, Integer> data = new Hashtable<>();

    public DummyDatabase() {
        data.put("alpha", 1);
        data.put("beta", 2);
        data.put("gamma", 3);
    }

    @Override
    public int getPopulation(String name) {
        return data.get(name);
    }
}

class DatabaseDemo {

    @Test
    public void singletonTotalPopulationTest() {
        SingletonRecordFinder rf = new SingletonRecordFinder();
        List<String> names = Arrays.asList("Seoul", "Mexico City");
        int tp = rf.getTotalPopulation(names);
        assertEquals(17500000+17400000, tp);
    }

    @Test
    public void dependentPopulationTest() {
        DummyDatabase db = new DummyDatabase();
        ConfigurableRecordFinder rf = new ConfigurableRecordFinder(db);
        assertEquals(4, rf.getTotalPopulation(Arrays.asList("alpha", "gamma")));
    }
}


class Stuff {
    public static void main(String[] args) {
        new DatabaseDemo().dependentPopulationTest();
    }
}
