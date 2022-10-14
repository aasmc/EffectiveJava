# Avoid creating unnecessary objects.

```java
// DON'T DO THIS
String s = new String("bikini");

Boolean.valueOf(String) // is better than 
new Boolean(String) // constructor creates a new object every time it is called
```

