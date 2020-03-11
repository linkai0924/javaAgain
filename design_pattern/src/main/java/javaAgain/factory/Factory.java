package javaAgain.factory;

/**
 * https://www.runoob.com/design-pattern/factory-pattern.html
 */
interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {

    }
}

class Square implements Shape {

    @Override
    public void draw() {

    }
}

public class Factory {

    public Shape getShape(String type) {
        if (type.equals("Rectangle")) {
            return new Rectangle();
        } else if (type.equals("Square")) {
            return new Square();
        } else {
            return null;
        }
    }

}
