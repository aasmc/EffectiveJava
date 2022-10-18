# Override clone judiciously

If a class implements Cloneable interface, Object's clone method returns a field-by-field copy of the object; otherwise it throws CloneNotSupportedException. 

**In practice, a class implementing Cloneable is expected to provide a properly functioning public clone method.** 

### Contract of clone method:
Creates and returns a copy of this object. The precise meaning of "copy" may depend on the class of the object. The general intent is that, for any object x, the expression
```java
x.clone() != x
```
will be true, and the expression
```java
x.clone().getClass() == x.getClass()
```
will be true, but these are not absolute requirements. While it is typically the case that
```java
x.clone().equals(x)
```
will be true, this is not an absolute requirement. 
By convention, the object returned by this method should be obtained by calling super.clone. If a class and all of its superclasses (except Object) obey this convention, it will be the case that
```java
x.clone().getClass() == x.getClass()
```
By convention, the returned object should be independent of the object being cloned. To achieve this independence, it may be necessary to modify one or more fields of the object returned by super.clone before returning it. 