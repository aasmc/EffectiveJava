# Minimize the accessibility of classes and members

The rule of thumb is simple: **make each class or member as inaccessible as possible**.

If a package-private top-level class is used only by one class, consider making the top-level class a private static nested class of the sole class that uses it.

If a method overrides a superclass method, it cannot have a more restrictive access level in the subclass than in the superclass. 

**Instance fields of public classes should rarely be made public**.

**Classes with public mutable fields are not generally thread-safe**.

Note that a nonzero-length array is always mutable. **So it is wrong for a class to have a public static final array field, or an accessor that returns such a field**. This is a frequent source of security holes. 
```java
// Potential security hole
public static final Thing[] VALUES = {...};

// option 1
private static final Thing[] PRIVATE_VALUES = {...};
public static final List<Thing> VALUES = 
    Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

// option 2
private static final Thing[] PRIVATE_VALUES = {...};
public static final Thing[] values() {
    return PRIVATE_VALUES.clone();    
}
```

