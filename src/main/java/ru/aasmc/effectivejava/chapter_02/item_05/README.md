# Dependency Injection

Do not use a singleton or static utility class to implement a class that depends on one or more
underlying resources whose behaviour affects that of the class, and do not have tha class create these resources directly. Instead, pass
the resources, or factories to create them, into the constructor (or static factory or builder). This practice, know as
dependency injection, will greatly enhance the flexibility, reusability and testability of a class. 