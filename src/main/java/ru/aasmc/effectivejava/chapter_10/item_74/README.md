# Document all exceptions thrown by each method

Always declare checked exceptions individually, and document precisely the conditions under which each one is thrown using the Javadoc @throws tag.

While the language doesn't require programmers to declare the unchecked exceptions that a method is capable of throwing, it is wise to document them as carefully as the checked exceptions. 

DO NOT document unchecked exceptions with @throws tag. 