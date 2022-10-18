# Obey the general contracts when overriding equals

## No need to override equals if:
- Each instance of the class is inherently unique.
- There's no need for the class t provide a "logical equality" test.
- A superclass has already overridden equals, and the superclass behavior is appropriate for this class. (e.g. Set, List etc.)
- The class is private or package-private, and you are certain that its equals method will never be invoked. 

## Contract of equals:
- Reflexive, for any non-null x, x.equals(x) must return true.
- Symmetric, for any non-null x and y, x.equals(y) must return true if and only if y.equals(x) returns true.
- Transitive, for any non-null x, y, z if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) must return true.
- Consistent, for any non-null x and y, multiple invocations of x.equals(y) must consistently return tru of consistently return false, provided no information used in equals comparisons is modified.
- for any non-null reference x, x.equals(null) must return false. 

## NB
There is no way to extend an instantiable class and add a value component while preserving the equals contract, unless you are willing to forgo the benefits of object-oriented abstraction. Using getClass() method instead of checking for instanceof violates Liskov substitution principle.
```java
@Override
public boolean equals(Object o) {
    // Now comparing a Point with any subclass will return false!
    if(o == null || o.getClass() != getClass()) {
        return false;
    }    
    Point p = (Point) o;
    return p.x == x && p.y == y;
}
```

## Java Library examples of incorrect usage of equals:
- java.sql.TimeStamp extends java.util.Date and adds a nanoseconds field. The equals implementation for TimeStamp does violate symmetry and can cause erratic behavior if TimeStamp and Date objects are used in the same collection or are otherwise intermixed. 
- Don't write an euqals method that depends on unreliable resource. E.G. java.net.URL's equals method relies on comparison of the IP addresses of the hosts associated with the URLs. Translating a host name to an IP address can require network access, and it isn't guaranteed to yield the same results over time. This can cause the URL equals method to violate the equals contract and has caused problems in practice. 

## Recipe for a high-quality equals method:
- Use the == operator to check if the argument is a reference to this object.
- Use the instance of operator to check if the argument has the correct type. If not, return false.
- Cast the argument to the correct type.
- For each "significant" field in the class, check if that field of the argument matches the corresponding field of this object.
- For float and double types use Float.compare(float, float) and Double.compare(double, double)
- For array fields, apply these guidelines to each field. If every element in an array field is significant, use one of the Arrays.equals() methods.
- Some object reference fields may legitimately contain null. To avoid the possibility of an NPE, check such fields for equality using the static method Objects.equals(Object, Object).
- For best performance you should first compare fields that are more likely to differ, less expensive to compare or, ideally, both. 
- You must not compare fields that are not part of an object's logical state (Locks etc.).
- Always override hashCode when you override equals. 