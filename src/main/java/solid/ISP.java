/**
 * インターフェース分離原則(The Interface Segregation Principle: ISP)
 * クライアントが使わないメソッドに依存することを強制されない
 * すべてのインターフェースを一つのクラスに押し込めてしまうのではなく、
 * 関連性を持ったインターフェースはグループ化し、抽象基本クラスとして分けて利用すべき
 *
 * 自分が使うインターフェースだけを依存すべきである
 * 単一のインターフェースより、複数のインターフェースを使うべきである
 * インターフェースをクライアントごとに分離すべきである
 *
 * インターフェース設計の原則
 * クライアントに使われていなかったメソッドをインターフェースから外すべき。
 * 必要なだけのメソッドを持つべきである　YAGNI
 * 複数のクラインとはインターフェースのそれぞれ異なるメソッドを使う場合、
 * それらのメソッドをそれぞれ別のインターフェースにすべき。
 *
 * インターフェース継承の原則
 * 例えインタフェースAはインタフェースBから継承したとし、そしてAはBのメソッドを有するとなり、
 * インタフェースBはもちろん、AもISP原則に従うべきである。
 */
package solid;

class Document {

}

interface Machine {
    void print(Document d);

    void fax(Document d) throws Exception;

    void scan(Document d);
}

class MultiFunctionPrinter implements Machine {
    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

class OldFashionedPrinter implements Machine {
    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) throws Exception {
        throw new Exception();
    }

    @Override
    public void scan(Document d) {

    }
}

interface Printer {
    void print(Document d);
}

interface Scanner {
    void scan(Document d);
}

// YAGNI = You Ain't Going to Need It

class JustAPrinter implements Printer {
    @Override
    public void print(Document d) {

    }
}

class Photocopier implements Printer, Scanner {
    @Override
    public void print(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

interface MultiFunctionDevice extends Printer, Scanner {
}

class MultiFunctionMachine implements MultiFunctionDevice {
    private Printer printer;
    private Scanner scanner;

    public MultiFunctionMachine(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void scan(Document d) {
        printer.print(d);
    }

    @Override
    public void print(Document d) {
        scanner.scan(d);
    }
}
