# Singleton Pattern

* Ensure a class only has one instance and provide a global point of access to it.

# Design principles

* 

# Bullet points

* The Singleton Pattern ensures you have at most one instance of a class in your application.
* The Singleton Pattern also provides a global access point to that instance.
* Java’s implementation of the Singleton Pattern makes use of a private constructor, a static method combined with a static variable.
* Examine your performance and resource constraints and carefully 
  choose an appropriate Singleton implementation for multithreaded applications (and we should consider all applications multithreaded!).
* Beware of the double-checked locking implementation; it isn’t thread safe in versions before Java 5.
* Be careful if you are using multiple class loaders; this could defeat the Singleton implementation and result in multiple instances.
* You can use Java’s enums to simplify your Singleton implementation.

   
- [BACK TO DESIGN-PATTERNS-README.md](../DESIGN-PATTERNS-README.md)