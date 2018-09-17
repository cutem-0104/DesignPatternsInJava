package factory;

enum CoordinateSystem {
    CARTESIAN,
    POLAR
}

class Point {
    private double x, y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param a is x if cartesian or rho if polar
     * @param b
     * @param cs
     */
    private Point(double a, double b, CoordinateSystem cs) {
        // enumでスイッチさせて、処理を分岐させるのは避けるべき
        switch (cs) {
            case CARTESIAN:
                this.x = x;
                this.y = y;
                break;
            case POLAR:
                x = a * Math.cos(b);
                y = a * Math.sin(b);
        }

    }

    // 同じ引数のコンストラクターを定義できないので、enumでスイッチさせる
//    public Point(double rho, double theta) {
//        x = rho * Math.cos(theta);
//        y = rho * Math.sin(theta);
//    }

    public static class Factory {
        // staticメソッドを用意して、メソッド内の処理で引数を加工してコンストラクタに渡す
        // メソッド名でどんなコンストラクタを生成するのか判断できるので、コメントを書く必要がなくなる
        // コンストラクタを生成したいクラス内でfactoryクラスを定義することで元のコンストラクタをprivateにできる

        public static Point newCartesianPoint(double x, double y) {
            return new Point(x, y);
        }

        public static Point newPolarPoint(double rho, double theta) {
            return new Point(rho*Math.cos(theta), rho*Math.sin(theta));
        }
    }
}


class Demo {
    public static void main(String[] args) {
        Point point = Point.Factory.newCartesianPoint(2, 3);
        Point point1 = Point.Factory.newPolarPoint(2, 3);
//        Point point2 = new Point(4, 5);
    }
}
