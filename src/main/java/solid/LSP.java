/**
 * リスコフの置換原則(The Liskov Substituion Principle: LSP)
 * サブクラスはスーパークラスを置き換えることができなければならない
 *
 * スーパークラスの意図から外れるオーバーライドをしてはいけない
 *
 * 派生型に求められるのは、「基本型の能力＋アルファ」であるということ。
 * 基本型にできることが、派生型でできなくなっているような継承の仕方では、LSP に反している
 *
 * 例えば、抽象クラスで宣言された get というメソッドを、
 * 実装時に使わせたくないなどの理由で例外が発生するようにしてしまった場合、
 * 実装クラスを抽象クラスの変わりに使えなくなってしまう。
 * if 文の分岐や instanceof などを使って、オブジェクトの型を判定しなければならなくなってしまいます。
 */
package solid;

class Rectangle {
    protected int width, height;

    public Rectangle() {
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    public boolean isSquare() {
        return width == height;
    }
}

class Square extends Rectangle {
    public Square() {
    }

    public Square(int size) {
        width = height = size;
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}

class RectangleFactory {
    public static Rectangle newSquare(int side) {
        return new Rectangle(side, side);
    }

    public static Rectangle newRectangle(int width, int height) {
        return new Rectangle(width, height);
    }
}

class LSPDemo {
    // maybe conform to ++
    static void useIt(Rectangle r) {
        int width = r.getWidth();
        r.setHeight(10);
        System.out.println("Expected area of " + (width * 10) + ", got " + r.getArea());
    }

    public static void main(String[] args) {
        Rectangle rc = new Rectangle(2, 3);
        useIt(rc);

        Rectangle sq = new Square();
        sq.setHeight(5);
        sq.setWidth(10);
        useIt(sq);
    }
}