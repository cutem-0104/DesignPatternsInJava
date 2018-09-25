package bridge;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

interface Renderer1 {
    void renderCircle(float radius);
}

class VectorRenderer1 implements Renderer1 {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle of radius " + radius);
    }
}

class RasterRenderer1 implements Renderer1 {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing pixels for a circle of raduis " + radius);
    }
}

abstract class Shape1 {
    protected Renderer1 renderer;

    public Shape1(Renderer1 renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();
    public abstract void resize(float factor);
}

class Circle extends Shape1 {
    public float radius;

    @Inject
    public Circle(Renderer1 renderer) {
        super(renderer);
    }

    public Circle(Renderer1 renderer, float radius) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }

    @Override
    public void resize(float factor) {
        radius*= factor;
    }
}

class ShapeModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Renderer1.class).to(VectorRenderer1.class);
    }
}

class Demo {
    public static void main(String[] args) {
//        RasterRenderer raster = new RasterRenderer();
//        VectorRenderer vector = new VectorRenderer();
//        Circle circle = new Circle(vector, 5);
//        circle.draw();
//        circle.resize(2);
//        circle.draw();
        Injector injector = Guice.createInjector(new ShapeModule());
        Circle instance = injector.getInstance(Circle.class);
        instance.radius = 3;
        instance.draw();
        instance.resize(2);
        instance.draw();
    }
}