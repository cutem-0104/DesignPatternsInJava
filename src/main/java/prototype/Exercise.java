package prototype;

class Point
{
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        //new Point(point.x, point.y); // コピーされない
        this(point.x, point.y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Line {
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line deepCopy() {
        // todo
        return new Line(new Point(start), new Point(end));
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}


class AAAA {
    public static void main(String[] args) {
        Line line = new Line(new Point(1, 3), new Point(2, 6));
        Line line1 = line.deepCopy();

        System.out.println(line);
        line1.start.x = 10;
        System.out.println(line1);
    }
}