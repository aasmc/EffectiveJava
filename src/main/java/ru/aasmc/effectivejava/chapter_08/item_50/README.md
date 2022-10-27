# Make defensive copies when needed

You must program defensively with the assumption that clients of your class will do their best to destroy its invariants. 

To protect the internals of a class it is essential to make a defensive copy of each mutable parameter to the constructor and use the copies in place of the originals.

Defensive copies are made *before* checking the validity of the parameters, and the validity check is performed on the copies rather than on the originals. It protects the class against changes to the parameters from another thread during the *window of vulnerability* between the time the parameters are checked and the time they are copied. This is known as *a time-of-check/time-of-use or TOCTOU* attack. To prevent this sort of attack, don't use the <code>clone</code> method to make a defensive copy of a parameter whose type is subclassable by untrusted parties. 

Remember that non-zero length arrays are always mutable, therefore, you should always make a defensive copy of an internal array before returning it to the client or return an immutable view of it.

