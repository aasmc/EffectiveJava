# Prefer primitive types to boxed primitives

Applying the == operator to boxed primitives is almost always wrong. 

When your program does mixed-type computations involving boxed and unboxed primitives it does unboxing, and when your program does unboxing, it can throw a NullPointerException.

When your program boxes primitive values, it can result in costly and unnecessary object creations. 