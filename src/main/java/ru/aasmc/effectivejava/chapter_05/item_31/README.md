# Use bounded wildcards to increase API flexibility

PECS: producer extends, consumer super.

Don't use bounded wildcard types as return types.

There's a duality between type parameters and wildcards, and many methods can be declared using one or the other. 
Example:
```java
// Two possible declarations for the swap method
public static <E> void swap(List<E> list, int i, int j);
public static void swap(List<?> list, int i, int j);
```

As a rule, if a type parameter appears only once in a method declaration, replace it with a wildcard.