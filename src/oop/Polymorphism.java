package oop;

/*Polymorphism is the ability to present the same interface for differing underlying forms (data types).
 With polymorphism, each of these classes will have different underlying data. Precisely, Poly means ‘many’ and morphism means ‘forms’.

Types of Polymorphism IMP
1. Compile Time Polymorphism (Static)=>method overloading(Method overloading is a technique which allows you to have more than one function with the same function name but with different functionality.)
2. Runtime Polymorphism (Dynamic) => method overriding(Declaring a method in sub class which is already present in parent class is known as method overriding.)

 */

public class Polymorphism {
    //method overloading
    static class Overloading{
        String name;
        int age;

        public void displayInfo(String name) {
            System.out.println(name);
        }

        public void displayInfo(int age) {
            System.out.println(age);
        }

        public void displayInfo(String name, int age) {
            System.out.println(name);
            System.out.println(age);
        }

    }
//2.example of method overriding

     static class Parent{
        void print(){
            System.out.println("parent class");

        }

    }

    static class SubClass extends Parent{
        void print(){
            System.out.println("this is child class");
        }
    }

    static class SecondSubClass extends Parent{
        void print(){
            System.out.println("secon child");
        }
    }

    public static void main(String[] args) {
        //so which implementation should be got decided in run time
        Parent p;
        p=new SubClass();
        p.print();

        p=new SecondSubClass();
        p.print();
    }



}
