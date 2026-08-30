# LLD Design Patterns

Java examples for low-level design and common object-oriented design patterns.

This repository is organized by pattern category and currently focuses on creational design patterns.

## Patterns Covered

| Category | Pattern | Package | Demo |
| --- | --- | --- | --- |
| Creational | Singleton - lazy, double-checked locking | `patterns.creational.singleton.lazy` | `patterns.creational.singleton.lazy.Tester` |
| Creational | Singleton - eager enum | `patterns.creational.singleton.eager` | `patterns.creational.singleton.eager.Tester` |
| Creational | Builder | `patterns.creational.builder` | `patterns.creational.builder.Tester` |

## Project Structure

```text
src/
  patterns/
    creational/
      builder/
        House.java
        Tester.java
        bad/
          BadHouse.java
      singleton/
        eager/
          EagerConfigManager.java
          Tester.java
        lazy/
          ConfigurationManager.java
          Tester.java
```

## Prerequisites

- JDK 8 or later
- A terminal that can run `javac` and `java`

This is a plain Java project. There is no Maven or Gradle build file.

## Compile

From the repository root, compile all source files:

```powershell
New-Item -ItemType Directory -Force out/production/lld-design-patterns | Out-Null
$javaFiles = Get-ChildItem -Path src -Recurse -Filter *.java
javac -d out/production/lld-design-patterns $javaFiles.FullName
```

## Run Examples

### Lazy Singleton

```powershell
java -cp out/production/lld-design-patterns patterns.creational.singleton.lazy.Tester
```

This example implements a lazy singleton with:

- A private constructor
- A `volatile` static instance field
- A public `getInstance()` method
- Double-checked locking inside a synchronized block

It also demonstrates how reflection can break this implementation by resetting the private static instance field or invoking the private constructor directly.

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

### Eager Enum Singleton

```powershell
java -cp out/production/lld-design-patterns patterns.creational.singleton.eager.Tester
```

This example implements the singleton as an enum:

```java
public enum EagerConfigManager {
    INSTANCE;
}
```

Repeated access to `EagerConfigManager.INSTANCE` returns the same object. The demo also attempts reflective construction, which standard Java reflection cannot use to create a second enum singleton instance.

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

### Builder

```powershell
java -cp out/production/lld-design-patterns patterns.creational.builder.Tester
```

This example compares:

- `BadHouse`, which requires a long constructor with many ordered parameters
- `House`, which uses a nested `HouseBuilder` for readable and chainable object construction

Expected output:

```text
Bad implementation:
BadHouse{door='Wooden Door', window='Glass Window', wall='Brick Wall', roof='Concrete Roof', swimmingPool='Big Pool', garden='Big Garden with Trees', garage='Medium', basement='Small'}

Good implementation using Builder pattern:
House{door='Wooden Door', window='Glass Window', wall='Brick Wall', roof='Concrete Roof', swimmingPool='Big Pool', garden='Big Garden with Trees', garage='Medium', basement='Small'}
```

## Notes

- Generated class files are written to `out/production/lld-design-patterns`.
- Source code is intentionally small and example-focused so each pattern can be read independently.
- Add new examples under `src/patterns/<category>/<pattern-name>` and include a `Tester` class when a pattern needs a runnable demo.
