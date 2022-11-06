# Implement <code>Serializable</code> with great caution

A major cost of implementing <code>Serializable</code> is that it decreases the flexibility to change a class's implementation once it has been released. When a class implements <code>Serializable</code> its byte-stream encoding (or *serialized form*) becomes part of its exported API. If you accept the default serialized for, the class's private and package-private instance fields become part of its exported API, and the practice to minimizing access to fields loses its effectiveness as a tool for information hiding. 

A second cost of implementing <code>Serializable</code> is that it increases the likelihood of bugs and security holes. Deserialization acts as a "hidden constructor", and as such it must ensure class invariants! 

A third const of implementing <code>Serializable</code> is that it increases the testing burden associated with releasing a new version of a class. 

Classes designed for inheritance should rarely implement <code>Serializable</code> and interfaces should rarely extend it:
- If there are any invariants on the instance field values, it is critical to prevent subclasses from overriding the <code>finalize</code> method, which the class can do by overriding <code>finalize</code> and declaring it final. 
- if the class has invariants that would be violated if its instance fields were initialized to their default values you must add this <code>readObjectNoData</code> method:
```java
private void readObjectNoData() throws InvalidObjectException {
    throw new InvalidObjectException("Stream data required");    
}
```

Inner classes should not implement <code>Serializable</code>.

A static member class can, however, implement <code>Serializable</code>.