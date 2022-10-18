# Always override hashCode when you override equals

## HashCode contract:
- When the hashCode method is invoked on an object repeatedly during an execution of an application, it must consistently return the same value, provided no information used in equals comparisons is modified.
- If two objects are equal according to the equals(Object) method, then calling hashCode on the two objects must produce the same result.
- If two objects are unequal according to the equals(Object) method, it is NOT REQUIRED that calling hashCode on each of the objects must produce distinct results.


## Recipe for a good hashCode function:
1. Declare and int type variable named result, and initialize it to the hash code c for the first significant field in your object, as computed in step 2.i.
2. For every remaining significant field f in your object, do the following:
   1. Compute an int hash code c for the field:
      1. if the field is of a primitive type, compute Type.hashCode(f), where Type is the boxed primitive class, corresponding to f's type.
      2. if the field is an object reference and this class's equals method compares the field by recursively invoking equals, recursively invoke hashCode on the field. If a more complex comparison is required, compute a "canonical representation" for this field and invoke hashCode on the canonical representation. If the value of the field is null, use 0 (or some other constant, but 0 is traditional).
      3. If the field is an array, treat it as if each significant element were a separate field. That is, compute a hash code for each significant element by applying these rules recursively, and combine the values per step 2.ii. If the array has no significant elements, use a constant, preferably non 0. If all elements are significant, use Arrays.hashCode().
   2. Combine the hash code c computed in Step 2.i into result as follows: result = 31 * result + c;
3. return result.

