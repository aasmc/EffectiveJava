# Favor generic methods

Example of using a recursive type bound to express mutual comparability
```java
public static <E extends Comparable<E>> E max(Collection<E> c);
```