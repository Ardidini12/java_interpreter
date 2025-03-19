# ALB Interpreter

A simple interpreter for the ALBOS, implemented in Java.
Run InterpreterMain.java -> it's the main file 

## Features

- Input statements (`LEXO`)
- Print statements (`AFISHO`)
- Variable assignments
- Basic arithmetic operations

## Syntax

```
LEXO variable_name    // Input a value
variable = value     // Assign a value
AFISHO variable      // Print a value
```

## Example Usage

```
> LEXO x
Enter value for x: 42
> x = 42
> AFISHO x
42
```

## Building and Running

1. Make sure you have Java 17 or later installed
2. Clone the repository
3. Build the project:
   ```bash
   mvn clean package
   ```
4. Run the interpreter:
   ```bash
   java -jar target/my-app-1.0-SNAPSHOT.jar
   ```

## Project Structure

- `src/main/java/alb/` - Core interpreter implementation
  - `Lexer.java` - Tokenizes input
  - `Parser.java` - Parses tokens into statements
  - `Token.java` - Token representation
  - `TokenType.java` - Token type enumeration
  - `statements/` - Statement implementations
    - `Statement.java` - Statement interface
    - `InputStatement.java` - Input statement
    - `PrintStatement.java` - Print statement
    - `AssignmentStatement.java` - Assignment statement 