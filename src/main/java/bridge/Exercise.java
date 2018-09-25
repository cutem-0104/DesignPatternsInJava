package bridge;

abstract class Shape {
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract String getName();
}

class Triangle extends Shape {
    public Triangle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String getName() {
        return "Triangle";
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as lines", getName());
    }
}

class Square extends Shape {
    public Square(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String getName() {
        return "Square";
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as lines", getName());
    }
}

class VectorSquare extends Square {
    public VectorSquare(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as lines", getName());
    }
}

class RasterSquare extends Square {
    public RasterSquare(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as pixels", getName());
    }
}

// imagine VectorTriangle and RasterTriangle are here too}


interface Renderer {
    public String whatToRenderAs();
}

class VectorRenderer implements Renderer {
    @Override
    public String whatToRenderAs() {
        return "Vector";
    }
}

class RasterRenderer implements  Renderer {
    @Override
    public String whatToRenderAs() {
        return "Raster";
    }
}

class AAA {
    public static void main(String[] args) {
        System.out.println(new Triangle(new RasterRenderer()).toString());
    }
}