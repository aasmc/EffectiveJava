# Combine generics and varags judiciously

@SafeVarargs annotation constitutes a promise by the author of a method that it is typesafe.

When a method with varargs number of parameters is invoked, an array is created out of the parameters.
If the method doesn't store anything into the array, and doesn't allow a reference to the array to escape,
then it is safe and can be annotated with @SafeVarargs. 

It is unsafe to give another method access to a generic varargs parameter array, with two exceptions:

- it is safe to pass the array to another varargs method that is correctly annotated with @SafeVarargs
- it is safe to pass the array to a non-varargs method that merely computs some function of the contents of the array

## NB
@SafeVarargs annotation is legal only on methods that can't be overridden. In Java 8 the annotation is legal only on static method and final instance methods. In Java 9 it became legal on private instance methods as well. 