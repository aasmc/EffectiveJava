# Document thread safety

To enable safe concurrent use, a class must clearly document what level of thread-safety it supports:

- Immutable - no external synchronization is necessary
- Unconditionally thread-safe - instances of this class are mutable, but the class has sufficient internal synchronization that its instances can be used concurrently without the need for any external synchronization (e.g.  AtomicLong, ConcurrentHashMap, etc.)
- Conditionally thread-safe - some methods require external synchronization for safe concurrent use. E.g. classes returned by Collections.synchronized wrappers. 
- Not thread-safe - Instances are mutable. To use them concurrently, clients must surround each method invocation with external synchronization. 
- Thread-hostile - the class is unsafe for concurrent use even if every method invocation is surrounded by external synchronization. Thread hostility usually results from modifying static data without synchronization.

Example from Collections.synchronizedMap: 
*it is imperative that the user manually synchronize on the returned map when iterating over any of its collection views*:
```java
Map<K, V> m = Collections.synchronizedMap(new HashMap<>());
Set<K> s = m.keySet(); // Needn't be in synchronized block
        ...
synchronized(m) {
    for (K key : s) {
        // process key    
    }            
}
```
*Failure to follow this advice may result in non-deterministic behavior.*

**A client can mount a denial-of-service attack by holding the publicly accessible lock for a prolonged period.**

Lock fields should always be declared final!

