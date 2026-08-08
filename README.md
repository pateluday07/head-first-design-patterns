# LLD Design Patterns

Java examples for low-level design and common object-oriented design patterns.

## Branch: 01-singleton-pattern

This branch demonstrates the Singleton creational design pattern with a thread-safe, lazily initialized `ConfigurationManager`.

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
configuration added..
configuration retrieved..
configuration added..
configuration retrieved..
true
true
true
```

The `true` values confirm that every call to `ConfigurationManager.getInstance()` returns the same object instance.
