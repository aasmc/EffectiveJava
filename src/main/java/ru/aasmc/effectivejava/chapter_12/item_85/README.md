# Prefer alternatives to Java serialization

You open yourself up to attack whenever you deserialize a byte stream that you don't trust.

The best way to avoid serialization exploits is never to deserialize anything. 

***There is no reason to use Java serialization in any new system you write!***

The leading cross-platform structured data representations are:
- JSON
- Protocol Buffers

Protocol Buffers are binary and much more efficient.

Never accept RMI traffic from untrusted sources. See Secure Coding Guidelines for Java https://www.oracle.com/java/technologies/javase/seccodeguide.html

If you can't avoid serialization and you aren't absolutely certain of the safety of the data you're
deserializing, use the object deserialization filter added in Java 9 (java.io.ObjectInputFilter). This lets you either blacklist or whitelist certain classes. Prefer whitelisting to blacklisting, since blacklisting protects you only against known threats. A tool called Serial Whitelist Application Trainer (SWAT) can be used to automatically prepare a whitelist for your application. 