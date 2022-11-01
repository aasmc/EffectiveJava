# Use checked exceptions for recoverable conditions and runtime exceptions for programming errors

Use checked exceptions for conditions from which the caller can reasonable be expected to recover.

The great majority of runtime exceptions indicate *precondition violations*.

All of the unchecked throwables you implement should subclass RuntimeException directly or indirectly. 

