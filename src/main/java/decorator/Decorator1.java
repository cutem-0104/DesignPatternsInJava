package decorator;

import java.util.function.Supplier;

interface Shape1 {
    String info();
}

class Circle1 implements Shape1 {
    private float radius;

    public Circle1(){}

    public Circle1(float radius) {
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

class Square1 implements Shape1 {
    private float side;

    public Square1() {}

    public Square1(float side) {
        this.side = side;
    }

    @Override
    public String info() {
        return "A square with size " + side;
    }
}

class ColoredShape1<T extends Shape1> implements Shape1 {
    private Shape1 shape;
    private String color;

    public ColoredShape1(Supplier<? extends T> ctor,
                         String color) {
        shape = ctor.get();
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info() + " has the color " + color;
    }
}

class TransparentShape1<T extends Shape1> implements Shape1 {
    private Shape1 shape;
    private int transparency;

    public TransparentShape1(Supplier<? extends T> ctor,
                             int transparency) {
        shape = ctor.get();
        this.transparency = transparency;
    }

    @Override
    public String info() {
        return shape.info() + " has " + transparency + "% transparency";
    }
}

class Demo11 {
    public static void main(String[] args) {
        ColoredShape1<Square1> blueSquare = new ColoredShape1<>(
                () -> new Square1(20), "blue"
        );
        System.out.println(blueSquare.info());

        TransparentShape1<ColoredShape1<Circle1>> myCircle =
                new TransparentShape1<>(() ->
                        new ColoredShape1<>(() -> new Circle1(5), "green"), 50);
        System.out.println(myCircle.info());
    }
}
