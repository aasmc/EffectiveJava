# For instance control, prefer enum types to <code>readResolve</code>

A deserialized singleton class is no longer a singleton, since we created a new instance of a class. 

The <code>readResolve</code> feature allows you to substitute another instance for the one created by <code>readObject</code>. If the class of a  object being deserialized defines a <code>readResolve</code> method with the proper declaration, this method is invoked on the newly created object after it is deserialized. The object reference returned by this method is then returned in place of the newly created object. 