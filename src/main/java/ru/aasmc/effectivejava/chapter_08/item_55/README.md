# Return optionals judiciously

Container types, including collections, maps, streams, arrays and optionals should not be wrapped in optionals. 

As a rule, you should declare a method to return <code>Optional<T></code> if it might not be able to return a result and clients will have to perform special processing if no result is returned. 

An Optional is an object that has to be allocated and initialized, and reading the value out of the optional requires an extra indirection. This makes optionals inappropriate for use in some performance-critical situations. 

You should NEVER return an optional of boxed primitive type. Instead use:
- OptionalInt
- OptionalLong
- OptionalDouble

Never use optionals as map values. More generally, it is almost never appropriate to use an optional as a key, value or element in a collection or array. 


