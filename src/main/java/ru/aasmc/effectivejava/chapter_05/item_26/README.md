# Don't use raw types

You lose type safety if you use raw type such as List, but not if you use a parameterized type such as List<Object>,
because e.g. List<String> is a subtype of a raw List, but not a subtype of List<Object>.

You can put any element into a collection with a raw type, easily corrupting the collection's type invariant. You cannot
put any element (other than null) into a Collection<?>.

You must use raw types in class literals: List.class, Collection.class. Illegal -> Collection<String>.class.

It is illegal to use the instanceof operator on parameterized types other than unbounded wildcard types. Preferred way
to use the instanceof operator with generic types:

```java
if(o instanceof Set) {
    Set<?> s=(Set<?>)o;
}
```

