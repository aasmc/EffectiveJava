# Consider using a custom serialized form

Do not accept the default serialized form without first considering whether it is appropriate. 

The default serialized form of an object is a reasonably efficient encoding of the *physical representation* of the object graph rooted at the object. The ideal serialized form of an object contains only the *logical data* represented by the object. It is independent of the physical representation. The default serialized form is likely to be appropriate if an object's physical representation is identical to its logical content. 

Even if you decide that the default serialized form is appropriate you often must provide a <code>readObject</code> method to ensure invariants and security.

Before deciding to make a field non-transient, convince yourself that its value is part of the logical state of the object. If you use a custom serialized form, most or all of the instance fields should be labeled <code>transient</code>. 

Whether or not you use the default serialized form, you must impose any synchronization on object serialization that you would impose on any other method that reads the entire state of the object. 

Example of a <code>writeObject</code> method for a synchronized thread-safe class:
```java
private synchronized voie writeObject(ObjectOutputStream s) throws IOException {
    s.defaultWriteObject();    
}
```

Regardless of what serialized form you choose, declare an explicit serial version UID in every serializable class you write.
```java
private static final long serialVersionUID = *randomLongValue*;
```

