package oop;
/*todo Inheritance in Java is a mechanism in which one object acquires all the properties and behaviors of a parent object.
* todo Why use inheritance in java
   1. For Method Overriding(so runtime polymorphismcan be achieved).
   2. For Code Reusability.
 */
public class Inheritance {
    /*todo 1. Single inheritance : When one class inherits another class, it is known
         as single level inheritance

     */

    class Shape {
        public void area() {
            System.out.println("Displays Area of Shape");
        }
    }
    class Triangle extends Shape {
        public void area(int h, int b) {
            System.out.println((1/2)*b*h);
        }
    }

   /* todo 2. Hierarchical inheritance : Hierarchical inheritance is defined as the process of deriving more than one class from a base class.

    */

    class Octagon extends Shape {
        public void area(int h, int b) {
            System.out.println((1/2)*b*h);
        }
    }
    class Circle extends Shape {
        public void area(int r) {
            System.out.println((3.14) * r * r);
        }
    }

    /*todo 3. Multilevel inheritance : Multilevel inheritance is a process of deriving a class from another derived class.

     */
    //class trangle which already defined above

    class EquilateralTriangle extends Triangle {
        int side;
    }

   /*todo 4. Hybrid inheritance :
       Hybrid inheritance is a combination of simple, multiple inheritance and hierarchical inheritance.

    */
}
