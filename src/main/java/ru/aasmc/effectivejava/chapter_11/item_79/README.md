# Avoid excessive synchronization

To avoid liveness and safely failures, never cede control to the client within a synchronized method or block. In other words, inside a synchronized region, do not invoke a method that is designed to be overridden, or one provided by a client in the form of a function object. From the perspective of the class with the synchronized region, such methods are *alien*.

An alien method invoked outside of a synchronized region is known as an *open call*. Besides preventing failures, open calls can greatly increase concurrency. 

As a rule, you should do as little work as possible inside synchronized regions. 

In a multicore world, the real cost of excessive synchronization is not the CPU time spent getting locks; it is contention: the lost opportunities for parallelism and the delays imposed by the need to ensure that every core has a consistent view of memory.

When in doubt, do not synchronize your class, but document it is not thread-safe. 

If a method modifies a static field and there's any possibility that the method will be called from multiple threads, you MUST synchronize access to the field internally. 