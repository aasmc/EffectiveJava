# Don't depend on the thread scheduler

Any program that relies on the thread scheduler for correctness or performance is likely to be non-portable.

Threads should not run if they are not doing useful work.

Threads should not busy-wait.

Resist the temptation to "fix" the program by putting in calls to Thread.yield when faced with a program that barely works because some threads aren't getting enough CPU time relative to others. ***Thread.yield has no testable semantics.***

***Thread priorities are among the least portable features of Java.***