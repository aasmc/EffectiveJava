# Prefer concurrency utilities to <code>wait</code> and <code>notify</code>

Given the difficulty of using wait and notify correctly, you should use the higher-level concurrency utilities instead.

The higher-level utilities fall into three categories:
- the Executor Framework
- concurrent collections
- synchronizers

It is impossible to exclude concurrent activity from a concurrent collection; locking it will only slow the program. Therefore you can't atomically compose method invocations on such collections. Concurrent collection interfaces were outfitted with *state-dependent modify operations*, which combine several primitives into a single atomic operation. 

The most commonly used synchronizers are:
- CountDownLatch
- Semaphore
- CyclicBarrier
- Exchanger
- Phaser

