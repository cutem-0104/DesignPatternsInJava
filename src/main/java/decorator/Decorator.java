package decorator;

interface Shape {
    String info();
}

class Circle implements Shape {
    private float radius;

    public Circle(){}

    public Circle(float radius) {
        this.radius = radius;
    }

    void resize(float factor) {
        radius *= factor;
    }

    @Override
    public String info() {
        return "A circle of radius " + radius;
    }
}

class Square implements Shape {
    private float side;

    public Square() {}

    public Square(float side) {
        this.side = side;
    }

    @Override
    public String info() {
        return "A square with size " + side;
    }
}

class ColoredShape implements Shape {
    private Shape shape;
    private String color;

    public ColoredShape(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info() + " has the color " + color;
    }
}

class TransparentShape implements Shape {
    private Shape shape;
    private int transparency;

    public TransparentShape(Shape shape, int transparency) {
        this.shape = shape;
        this.transparency = transparency;
    }

    @Override
    public String info() {
        return shape.info() + " has " + transparency + "% transparency";
    }
}

class Demo1 {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        System.out.println(circle.info());

        ColoredShape blue = new ColoredShape(new Square(20), "blue");
        System.out.println(blue.info());

        TransparentShape green = new TransparentShape(
                new ColoredShape(
                        new Circle(5),
                        "green"), 50);
        System.out.println(green.info());
    }
}