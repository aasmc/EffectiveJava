# Favor the use of standard functional interfaces

If one of the standard functional interfaces does the job, you should generally use it in preference to a purpose-build functional interface. 

Don't vbe tempted to use basic functional interfaces with boxed primitives instead of primitive functional interfaces.

You should consider writing a purpose-build functional interface if:
- it will be commonly used and could benefit from a descriptive name
- it has a strong contract associated with it
- it would benefit from custom default methods

**Always annotate your functional interface with the @FunctionalInterface annotation**.

