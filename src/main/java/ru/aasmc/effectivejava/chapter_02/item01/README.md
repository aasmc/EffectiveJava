# Static factory methods

## Advantages:
- have names
- are not required to create new objects every time they are called
- can return an object of any subtype of the return type
- class of the returned object can vary from call to call as a function of the input parameters
- class of the returned object need not exist when the class containing the method is written

## Disadvantages:
- classes without public or protected constructors cannot be subclassed
- hard to find in the javadoc
