# Use lazy initialization judiciously

Use static holder class idiom for lazy initialization of a static field.

Use double-check locking to lazily initialize an instance field:

```java
private volatile FieldType field;

private FieldType getField() {
    FieldType result = field;
    if(result == null) {
        synchronized(this) {
            if(field == null) {
                field = result = computeFieldValue();
            }   
        }
    }
}
```