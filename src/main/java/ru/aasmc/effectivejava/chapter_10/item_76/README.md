# Strive for failure atomicity

Generally speaking, a failed method invocation should leave the object in the state that it was in prior to the invocation. A method with this property is said to be *failure-atomic*.

For immutable objects failure atomicity comes for free.

For methods that operate on mutable objects, the most common way to achieve failure atomicity is to check parameters for validity before performing the operation.

A closely related approach to achieving failure atomicity is to order the computation so that any part that may fail takes place before any part that modifies the object. 

Another approach to achieving failure atomicity is to perform the operation on a temporary copy of the object and to replace the contents of the object with the temporary copy once the operation is complete.

A last and far less common approach is to write recovery code that intercepts a failure that occurs in the midst of an operation, and causes the object to roll back its state to the point before the operation began. 

If it is impossible to achieve failure atomicity, then API documentation should clearly indicate what state the object will be left in. 