# Avoid finalizers and cleaners

Finalizers are unpredictable, often dangerous, and generally unnecessary.

As of Java 9, finalizers have been deprecated. Cleaners are a replacement. They are
less dangerous than finalizers, but still unpredictable, slow and generally unnecessary.

You should never depend on a finalizer or cleaner to update persistent state.
Another problem with finalizers is that an uncaught exception thrown during finalization is ignored, and finalization of that object terminates.
Uncaught exceptions can leave other objects in a corrupt state. If such an exception occurs in finalizer, it won't even print a warning. 

There's a severe performance penalty for using finalizers and cleaners. 

## Finalizers have a serious security problem:
They open your class up to finalizer attacks. The idea behind such attacks is simple:
if an exception is thrown from a constructor or its serialization equivalents - the readObject() and readResolve() methods - the finalizer
of a malicious subclass can run on the partially constructed object that should have "died on the vine". This finalizer can record
a reference to the object in a static field, preventing it from being garbage collected. Once the malformed object has been recorded, it is a simple matter
to invoke arbitrary methods on this object that should never have been allowed to exist in the first place. **Throwing an exception from a constructor should be
sufficient to prevent an object from coming into existence; in the presence of finalizers, it is not. To protect nonfinal classes from finalizer attacks 
write a final finalize() method that does nothing.** 