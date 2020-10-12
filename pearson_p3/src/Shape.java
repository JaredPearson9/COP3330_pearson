abstract class Shape extends Shape2D{

    String getName() {
        String name = "";

        if (this instanceof Square){
            name = "square";
        }
        if (this instanceof Triangle){
            name = "triangle";
        }
        if (this instanceof Circle){
            name = "circle";
        }
        if (this instanceof Cube){
            name = "cube";
        }
        if (this instanceof Pyramid){
            name = "pyramid";
        }
        if (this instanceof Sphere){
            name = "sphere";
        }

        return name;
    }

}

abstract class Shape2D extends Shape3D{

    double getArea() {
        double area = 0;

        if (this instanceof Square){
            area = ((Square) this).getAreaSquare();
        }
        if (this instanceof Triangle){
            area = ((Triangle) this).getAreaTriangle();
        }
        if (this instanceof Circle){
            area = ((Circle) this).getAreaCircle();
        }
        if (this instanceof Cube){
            area = ((Cube) this).getAreaCube();
        }
        if (this instanceof Pyramid){
            area = ((Pyramid) this).getAreaPyramid();
        }
        if (this instanceof Sphere){
            area = ((Sphere) this).getAreaSphere();
        }

        return area;
    }

}

abstract class Shape3D{

    double getArea() {
        double area = 0;

        if (this instanceof Square){
            area = ((Square) this).getAreaSquare();
        }
        if (this instanceof Triangle){
            area = ((Triangle) this).getAreaTriangle();
        }
        if (this instanceof Circle){
            area = ((Circle) this).getAreaCircle();
        }
        if (this instanceof Cube){
            area = ((Cube) this).getAreaCube();
        }
        if (this instanceof Pyramid){
            area = ((Pyramid) this).getAreaPyramid();
        }
        if (this instanceof Sphere){
            area = ((Sphere) this).getAreaSphere();
        }

        return area;
    }

    double getVolume() {
        double volume = 0;

        if (this instanceof Cube){
            volume = ((Cube) this).getVolumeCube();
        }
        if (this instanceof Pyramid){
            volume = ((Pyramid) this).getVolumePyramid();
        }
        if (this instanceof Sphere){
            volume = ((Sphere) this).getVolumeSphere();
        }

        return volume;
    }

}

class Square extends Shape {
    double length;
    Square(double length) {
        this.length = length;
    }
    double getAreaSquare(){
        return length * length;
    }

}

class Triangle extends Shape{
    double base;
    double height;
    Triangle(double base,double height) {
        this.base = base;
        this.height = height;
    }
    double getAreaTriangle(){
        return (base * height) / 2.0;
    }
}

class Circle extends Shape{
    double radius;
    Circle(double radius) {
        this.radius = radius;
    }
    double getAreaCircle(){
        return Math.PI * (radius * radius);
    }
}

class Cube extends Shape{
    double length;

    Cube(double length) {
        this.length = length;
    }

    double getAreaCube(){
        return (length * length) * 6.0;
    }

    double getVolumeCube(){
        return (length * length * length);
    }

}

class Pyramid extends Shape{
    double length;
    double width;
    double height;

    Pyramid(double length,double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    double getAreaPyramid(){
        return (length * width) + length * Math.sqrt(((width/2.0) * (width/2.0)) + (height * height)) + width * Math.sqrt(((length/2.0) * (length/2.0)) + (height * height));
    }

    double getVolumePyramid(){
        return (length * width * height) / 3.0;
    }

}

class Sphere extends Shape{
    double radius;

    Sphere(double radius) {
        this.radius = radius;
    }

    double getAreaSphere(){
        return 4.0 * Math.PI * (radius * radius);
    }

    double getVolumeSphere(){
        return (4.0/3.0) * Math.PI * (radius * radius * radius);
    }

}