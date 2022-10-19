# Minimize mutability

Rules to make class immutable:
- Don't provide methods that modify the object's state.
- Ensure that the class can't be extended.
- Make all fields final.
- Make all fields private.
- Ensure exclusive access to any mutable components. Ensure that clients of the class cannot obtain references to fields that refer to mutable objects. Never initialize such a field to a client-provided object reference or return the field from an accessor. Make defensive copies in constructors, accessors and readObject() methods. 

Immutable objects are inherently thread-safe; they require no synchronization.

Immutable objects make great building blocks for other objects. 

Immutable objects provide failure atomicity for free. Their state never changes, so there is no possibility of a temporary inconsistency.

The major disadvantage of immutable classes is that they require a separate object for each distinct value. 

## NB. Security Issue.
Methods in BigInteger and BigDecimal classes can be overridden, and if your class depends on the immutability of a 
BigInteger or a BigDecimal argument from an untrusted client, you must check to see that the argument is a "real" BigInteger or BigDecimal
rather that an instance of an untrusted subclass. If it is the latter, you must defensively copy it under the assumption that it might be mutable:
```java
public static BigInteger safeInstance(BigInteger val) {
    return val.getClass() == BigInteger.class ? val : new BigInteger(val.toByteArray());    
}
```

One caveat should be added concerning serializability. If you choose to have your immutable class implement Serializable interface and it contains one or
more fields that refer to mutable objects, you must provide an explicit readObject() or readResolve() methods, or use 
ObjectOutputStream.writeUnshared() and ObjectInputStream.readUnshared() methods, even if the default serialized form is acceptable. Otherwise the attacker could
create a mutable instance of your class. See Item 88. 

**If a class cannot be made immutable, limit its mutability as much as possible.**

**Constructors should create fully initialized objects with all of their invariants established.**