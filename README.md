# LLD Design Patterns

Java examples for low-level design and common object-oriented design patterns.

## Branch: 01-singleton-enum

This branch demonstrates the Singleton creational design pattern with two implementations:

- A lazy, thread-safe singleton using double-checked locking.
- An eager enum singleton using `INSTANCE`.

The examples also show how Java reflection affects each implementation.

## Implementations

### Lazy Singleton

Package:

```text
patterns.creational.singleton.lazy
```

`ConfigurationManager` uses:

- A private constructor to prevent direct object creation.
- A static `volatile` instance field.
- A public `getInstance()` accessor.
- Double-checked locking inside a synchronized block.

`lazy.Tester` shows that normal calls to `getInstance()` return the same object, but reflection can still break this implementation by:

- Resetting the private static `instance` field.
- Invoking the private constructor directly.

### Eager Enum Singleton

Package:

```text
patterns.creational.singleton.eager
```

`EagerConfigManager` is implemented as an enum:

```java
public enum EagerConfigManager {
    INSTANCE;
}
```

`eager.Tester` shows that repeated access to `EagerConfigManager.INSTANCE` returns the same object. It also attempts reflective construction, but standard Java reflection cannot create a second enum singleton instance.

## Project Structure

```text
src/
  patterns/
    creational/
      singleton/
        lazy/
          ConfigurationManager.java
          Tester.java
        eager/
          EagerConfigManager.java
          Tester.java
```

## Compile

From the repository root:

```powershell
javac -d out/production/lld-design-patterns src/patterns/creational/singleton/lazy/*.java src/patterns/creational/singleton/eager/*.java
```

## Run the Lazy Singleton Example

```powershell
java -cp out/production/lld-design-patterns patterns.creational.singleton.lazy.Tester
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
The `false` values show that resetting the private static instance field or invoking the private constructor through reflection can break this singleton implementation.

## Run the Eager Enum Singleton Example

```powershell
java -cp out/production/lld-design-patterns patterns.creational.singleton.eager.Tester
```

Expected output:

```text
Eager Singleton Pattern creating configuration manager using INSTANCE enum..

configuration added..
configuration added..

comparing configManager1 and configManager2 using == operator..
true

creating configManager3 using reflection by accessing the private constructor..
Reflection attack failed: patterns.creational.singleton.eager.EagerConfigManager.<init>()
```

The `true` confirms that repeated access to `EagerConfigManager.INSTANCE` returns the same enum instance.
The reflection attempt does not create another object. Enum singletons are protected from normal reflection-based constructor attacks by the JVM.
