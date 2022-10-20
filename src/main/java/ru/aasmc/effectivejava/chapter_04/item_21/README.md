# Design interfaces for posterity

When adding a new default method to an old interface, take into account that it is not always possible to write a default method that maintains all invariants of every conceivable implementation. 

In the presence of default methods, existing implementations of an interface may compile without error or warning but fail at runtime. 