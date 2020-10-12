abstract class Shape{

    abstract String getName();

    abstract double getArea();

}

abstract class Shape2D extends Shape{

}

abstract class Shape3D extends Shape{

    abstract double getVolume();

}

class Square extends Shape2D{
    double length;
    Square(double length) {
        this.length = length;
    }

    String getName(){
        return "square";
    }

    double getArea(){
        return length * length;
    }

}

class Triangle extends Shape2D{
    double base;
    double height;
    Triangle(double base,double height) {
        this.base = base;
        this.height = height;
    }

    String getName(){
        return "triangle";
    }

    double getArea(){
        return (base * height) / 2.0;
    }

}

class Circle extends Shape2D{
    double radius;
    Circle(double radius) {
        this.radius = radius;
    }

    String getName(){
        return "circle";
    }

    double getArea(){
        return Math.PI * (radius * radius);
    }

}

class Cube extends Shape3D{
    double length;

    Cube(double length) {
        this.length = length;
    }

    String getName(){
        return "cube";
    }

    double getArea(){
        return (length * length) * 6.0;
    }

    double getVolume(){
        return (length * length * length);
    }

}

class Pyramid extends Shape3D{
    double length;
    double width;
    double height;

    Pyramid(double length,double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    String getName(){
        return "pyramid";
    }

    double getArea(){
        return (length * width) + length * Math.sqrt(((width/2.0) * (width/2.0)) + (height * height)) + width * Math.sqrt(((length/2.0) * (length/2.0)) + (height * height));
    }

    double getVolume(){
        return (length * width * height) / 3.0;
    }

}

class Sphere extends Shape3D{
    double radius;

    Sphere(double radius) {
        this.radius = radius;
    }

    String getName(){
        return "sphere";
    }

    double getArea(){
        return 4.0 * Math.PI * (radius * radius);
    }

    double getVolume(){
        return (4.0/3.0) * Math.PI * (radius * radius * radius);
    }

}