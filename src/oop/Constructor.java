package oop;
/*
Constructor : Constructor is a special method which is invoked automatically at the time of object creation. It is used to initialize the data members of new objects generally.
- Constructors have the same name as class or structure.
- Constructors don’t have a return type. (Not even void)
- Constructors are only called once, at object creation.
There can be three types of constructors in Java.

1.Non-parameterized constructor=> A constructor which has no argument is known as non-parameterized constructor(or no-argument constructor).
  It is invoked at the time of creating an object. If we don’t create one then it is created by default by Java.

2.parameterized constructor =>Constructor which has parameters is called a parameterized constructor. It is used to provide
different values to distinct objects.

3.Copy constructor => A Copy constructor is an overloaded constructor used to declare and initialize an object from another object.
 */

public class Constructor {
    String name;


    //1. non parameterized constructor
    public Constructor() {
        System.out.println("non paramterized");
    }

    //2. parametrized constructor
    public Constructor(String name) {
        this.name = name;
    }

    //3. copy constructor
    public Constructor(Constructor constructor) {
        this.name = constructor.name;
    }

    /*Note : Unlike languages like C++, Java has no Destructor.
     Instead, Java has an efficient  garbage collector that deallocates memory automatically.
*/


}
