# Design and document for inheritance or else prohibit it

The class must document its self-use of overridable methods. 

To enable @implSpec tag in Javadoc utility you need to pass the command line switch -tag "apiNote:a:API Node:". @implSpec is used to document implementation details of a particular method. 

To allow programmers to write efficient subclasses without undue pain, a class may have to provide hooks into its internal workings in the form of judiciously chosen protected methods. 

**The only way to test a class designed for inheritance is to write subclasses.**

Constructors of a class designed for inheritance **must not invoke overridable methods.**

It is safe to invoke private methods, final methods, and static methods, none of which are overridable, from a constructor. 

It is generally not a good idea for a class designed for inheritance to implement Cloneable or Serializable. If you do implement those interfaces, then consider that **neither clone() nor readObject() may invoke an overridable method, directly or indirectly**.

Ways to prohibit a class from subclassing:
- make the class final
- make constructors private or package-private and add public static factories instead

