# Use varargs judiciously

Every time a method with variable number of arguments is called, an array is created, and the arguments are placed in the array. This is a performance penalty.  