# Clojure introduction 

- Clojure is an alloy of Lisp and functional programming
- The Lisp heritage gives you the power to write code more expressively than is possible in most non-Lisp languages
- Concurrent programming
- Clojure is a hosted language. 
- Clojure programs are executed within a JVM and rely on the JVM for core features like threading and garbage collection. 
- Clojure also targets JavaScript and the Microsoft Common Language Runtime (CLR)
- **All Lisps, Clojure included, employ prefix notation, meaning that the operator always comes first in an expression.**
- Clojure’s syntax is simple. Like all Lisps, it employs a uniform structure, a handful of special operators, and a constant supply of parentheses delivered from **the parenthesis mines hidden beneath the Massachusetts Institute of Technology, where Lisp was born**.
- All Clojure code is written in a uniform structure. Clojure recognizes two kinds of structures:
    1. literal representations of data structures (like numbers, strings, maps and vectors)
    2. Operations
- the term **form** is used to refer to valid code.
- Clojure evaluates every form to produce a value. the following literals are representations of valid forms
> 
> 1
> " a string"
> ["a" "vector" "of" "strings"]
>
- liteals are used in operations
- Operations are how you do things. All Operations take the form of *opening parenthesis, operator, operands, closing parenthesis*
>
> (operator operand1 operand 2 ... operandn)
>
- Clojure uses whitespace to separate operands, and it treats commas as whitespace. NO COMMAS!
- the **+** operator adds the operrands 
- the **str** operator concatenates strings to form a new string 
- Clojure’s support for first-class functions allows you to build more power­f ul abstractions than you can in languages without them. Those unfamiliar with this kind of programming think of functions as allowing you to generalize operations over data instances.
- Clojure (and all Lisps) allows you to create functions that generalize over processes.
- 


## Clojure language
- The Clojure language is a Lisp dialect with a functional emphasis whose syntax and semantics are independent of any implementation. 

## Clojure compiler
- The compiler is an executable JAR file, clojure.jar, which takes code written in the Clojure language and compiles it to Java Virtual Machine (JVM) bytecode.

## Clojure and JVM
- JVM processes execute Java bytecode.
- Usually, the Java Compiler produces Java bytecode from Java source code.
- JAR files are collections of Java bytecode.
- Java programs are usually distributed as JAR files.
- The Java program clojure.jar reads Clojure source code and produces Java bytecode.
- That Java bytecode is then executed by the same JVM process already running clojure.jar.

# ns
- ns declare a namespace

# -main
- the -main function is the entry point to your program

# Simplicity 
- Clojure’s emphasis on simplicity encourages you to reach for the built-in data structures first.
- It is better to have 100 functions operate on one data structure than 10 functions on 10 data structures. —Alan Perlis
- gain code reusability by sticking to basic data structures

# Errors
- *cannot be cast to clojure.lang.IFn* just means that you’re trying to use something as a function when it’s not.
- 