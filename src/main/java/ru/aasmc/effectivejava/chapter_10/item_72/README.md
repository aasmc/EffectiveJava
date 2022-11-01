# Favor the use of standard exceptions

Do not use Exception, RuntimeException, Throwable or Error directly.

The most commonly reused exceptions:

- IllegalArgumentException
- IllegalStateException
- NullPointerException
- IndexOutOfBoundsException
- ConcurrentModificationException
- UnsupportedOperationException

## N.B.
Remember that exceptions are serializable. That alone is reason not to write your own exception class without good reason.

