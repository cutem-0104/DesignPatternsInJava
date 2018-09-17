/**
 * 単一責任の原則(The Single Responsibility Principle: SRP)
 * クラスに変更が起こる理由は一つであるべき
 * 複数の役割を持ったクラスは、変更理由も複数になっていまい、変更部分がわかりづらくなります。
 *
 * 常に同時に変更される場合は、1つの役割を持っていると言っても問題ありません。
 * 単一責任の原則を適用するには、どのような点に気をつければいいのでしょうか？
 * その答えの一つに、「GRASP (General Responsibility Assignment Software Patterns)」というものがあります。
 */
package solid;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Journal {
    private final List<String> entries = new ArrayList<>();

    private static int count = 0;

    public void addEntry(String text) {
        entries.add("" + (++count) + ": " + text);
    }

    public void removeEntry(int index) {
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }

    // here we break SRP
    public void save(String filename) throws Exception {
        try (PrintStream out = new PrintStream(filename)) {
            out.println(toString());
        }
    }

    public void load(String filename) {
    }

    public void load(URL url) {
    }
}

// handles the responsibility of persisting objects
class Persistence {
    public void saveToFile(Journal journal,
                           String filename, boolean overwrite) throws Exception {
        if (overwrite || new File(filename).exists())
            try (PrintStream out = new PrintStream(filename)) {
                out.println(journal.toString());
            }
    }

    public void load(Journal journal, String filename) {
    }

    public void load(Journal journal, URL url) {
    }
}

class SRPDemo {
    public static void main(String[] args) throws Exception {
        Journal j = new Journal();
        j.addEntry("I cried today");
        j.addEntry("I ate a bug");
        System.out.println(j);

        Persistence p = new Persistence();
        String filename = "c:\\temp\\journal.txt";
        p.saveToFile(j, filename, true);

        // windows!
        Runtime.getRuntime().exec("notepad.exe " + filename);
    }
}