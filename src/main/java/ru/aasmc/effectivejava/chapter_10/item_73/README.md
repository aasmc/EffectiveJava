# Throw exceptions appropriate to the abstraction

Higher layers should catch lower-level exceptions and in their place throw exceptions that can be explained in terms of the higher-level abstraction. This is known as *exception translation*. If the lower-level exception may be helpful for debugging, then pass it as a cause in the constructor of the higher-level exception.

While exception translation is superior to mindless propagation of exceptions from lower-layers, it should not be overused. 