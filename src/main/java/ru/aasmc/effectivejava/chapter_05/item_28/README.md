# Prefer lists to arrays

Arrays are covariant, generics are invariant. 
```java
// Fails at runtime.
Object[] objectArray = new Long[1];
objectArray[0] = "I don't fit in"; // Throws ArrayStoreException

List<Object> ol = new ArrayList<Long>(); // Won't compile since types are incompatible.
ol.add("I don't fit in");
```

Arrays are reified, i.e. arrays know and enforce their element type at runtime. 
Generics are implemented by erasure, i.e. they enforce their type constraints at compile-time and discard
or erase their element type information at runtime. 

It is illegal to create an array of generic type, a parameterized type or a type parameter:

```java
// Illegal
new List<E>[];
new List<String>[];
new E[];
```