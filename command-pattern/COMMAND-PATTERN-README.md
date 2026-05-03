# Command pattern
* Encapsulates a request as ana object, thereby letting you parameterize clients with different requests,
  queue or log requests, and support undoable operations.

# Design principles
*   Depend on abstractions. Do not depend on concrete classes.

# Bullet points
* The Command Pattern decouples an object making a request from the one that knows how to perform it.
* A Command object is at the center of this decoupling and encapsulates a receiver with an action (or set of actions).
* An invoker makes a request of a Command object by calling its execute() method, which invokes those actions on the receiver.
* Invokers can be parameterized with Commands, even dynamically at runtime.
* Commands may support undo by implementing an undo() method that restores the object to its previous state before the execute() method was last called.
* MacroCommands are a simple extension of the Command Pattern that allow multiple commands to be invoked. Likewise, MacroCommands can easily support undo().
* In practice, it’s not uncommon for “smart” Command objects to implement the request themselves rather than delegating to a receiver.
* Commands may also be used to implement logging and transactional systems.

- [BACK TO DESIGN-PATTERNS-README.md](../DESIGN-PATTERNS-README.md)
