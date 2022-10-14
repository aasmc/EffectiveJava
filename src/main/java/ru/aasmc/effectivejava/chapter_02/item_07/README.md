# Memory leaks

Whenever a class manages its own memory, the programmer should be alert for memory leaks. Whenever an element is freed,
any object references contained in the element should be nulled out.

Another common source of memory leaks is caches. To prevent memory leaks in caches it is often recommended to use
WeakHashMap to store keys to entries. WeakHashMap ensures that an entry is garbage collected when there're no
external references to the key.

A third common source of memory leaks is listeners ano other callbacks. 