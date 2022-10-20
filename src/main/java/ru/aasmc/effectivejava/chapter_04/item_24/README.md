# Favor static member classes over nonstatic

Types of nested classes:
- static member classes
- nonstatic member classes
- anonymous classes
- local classes

All but the first type (static member class) are known as inner classes. 

## Static member class
Declared inside another class and has access to all of the enclosing class's members, even those declared private. 
One common use is as a public helper class. 

## Nonstatic member class
Implicitly associated with an enclosing instance of its containing class. Within instance methods of a nonstatic member class,
you can invoke methods on the enclosing instance or obtain a reference to the enclosing instance using the qualified this construct. 
It is impossible to create an instance of a nonstatic member class without an enclosing instance. 

One common use of a nonstatic member class is to define an Adapter that allows an instance of the outer class to be viewed as an instance 
of some unrelated class. 

### If you declare a member class that does not require access to an enclosing instance, always put the static modifier in its declaration.

## Anonymous class
It is not a member of its enclosing class. Permitted at any point in the code where an expression is legal. 
Have enclosing instances if and only if they occur in a nonstatic context. 
Cannot have static members other than constant variables, which are final primitive or string fields initialized to constant expressions. 

## Local class
Can be declared anywhere a local variable can be declared, obeys the same scoping rules. 