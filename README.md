# LLD Design Patterns

Java examples for low-level design and common object-oriented design patterns.

## Branch: 01-singleton-reflection

This branch demonstrates the Singleton creational design pattern with a thread-safe, lazily initialized `ConfigurationManager`.
The tester also shows how reflection can bypass this basic implementation and create different instances.

The implementation uses:

- A private constructor to prevent direct object creation.
- A static `volatile` instance field.
- A public `getInstance()` accessor.
- Double-checked locking inside a synchronized block.

## Project Structure

```text
src/
  patterns/
    creational/
      singleton/
        ConfigurationManager.java
        Tester.java
```

## Run the Example

From the repository root:

```bash
javac -d out/production/lld-design-patterns src/patterns/creational/singleton/*.java
java -cp out/production/lld-design-patterns patterns.creational.singleton.Tester
```

Expected output:

```text
Singleton Pattern creating configuration manager using getInstance() method..
comparing configManager1 and configManager2 using == operator..
true

creating configManager3 using reflection by accessing the private instance field..
comparing configManager1 and configManager3 using == operator..
false

creating configManager4 using reflection by accessing the private constructor..
comparing configManager1 and configManager4 using == operator..
false
```

The first `true` confirms that repeated calls to `ConfigurationManager.getInstance()` return the same object instance.
The `false` values show that resetting the private static instance field or invoking the private constructor through reflection can break this basic Singleton implementation.
