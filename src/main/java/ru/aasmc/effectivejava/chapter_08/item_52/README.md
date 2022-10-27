# Use overloading judiciously


The choice of which overloading to invoke is made at compile-time. 

## REMEMBER
Selection among overloaded methods is static, while selection among overridden methods is dynamic. 

A safe conservative policy is never to export two overloadings with the same number of parameters.


DO NOT overload methods to take different functional interfaces in the same argumenbt position. 