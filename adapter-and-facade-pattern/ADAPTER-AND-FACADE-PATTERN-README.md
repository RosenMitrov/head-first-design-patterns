# Command pattern

* Adapter
    * Converts the interface of a class into another interface clients expect. Lets Classes work together that could not
      otherwise because of incompatible interfaces.
* Facade
    * Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that
      make the subsystem easier to use.

# Design principles

* Principle of Least Knowledge: Talk only to your friends.

# Bullet points

* When you need to use an existing class and its interface is not the one you need, use an adapter.
* When you need to simplify and unify a large interface or complex set of interfaces, use a facade.
* An adapter changes an interface into one a client expects.
* A facade decouples a client from a complex subsystem.
* Implementing an adapter may require little work or a great deal of work depending on the size and complexity of the
  target interface.
* Implementing a facade requires that we compose the facade with its subsystem and use delegation to perform the work of
  the facade.
* There are two forms of the Adapter Pattern: object and class adapters. Class adapters require multiple inheritance.
* You can implement more than one facade for a subsystem.
* An adapter wraps an object to change its interface, a decorator wraps an object to add new behaviors and
  responsibilities, and a facade “wraps” a set of objects to simplify.

- [BACK TO DESIGN-PATTERNS-README.md](../DESIGN-PATTERNS-README.md)
