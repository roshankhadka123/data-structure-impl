package oop;
/* Encapsulation is the process of combining data and functions into a single unit called class.
In Encapsulation, the data is not accessed directly; it is accessed through the functions(getter) present inside the class.
 */
public class Encapsulation {


    // fields to calculate area
    static class Area {

        int length;
        int breadth;

        // constructor to initialize values
        Area(int length, int breadth) {
            this.length = length;
            this.breadth = breadth;
        }

        // method to calculate area
        public void getArea() {
            int area = length * breadth;
            System.out.println("Area: " + area);
        }
    }


        public static void main(String[] args) {

            Area rectangle = new Area(2, 16);
            rectangle.getArea();
        }

}
