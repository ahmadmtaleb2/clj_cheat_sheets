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
> 1
>
> " a string"
>
> ["a" "vector" "of" "strings"]

- liteals are used in operations
- Operations are how you do things. All Operations take the form of *opening parenthesis, operator, operands, closing parenthesis*
> (operator operand1 operand 2 ... operandn)

- Clojure uses whitespace to separate operands, and it treats commas as whitespace. NO COMMAS!
- the **+** operator adds the operrands 
- the **str** operator concatenates strings to form a new string 
- Clojure’s support for first-class functions allows you to build more power­ful abstractions than you can in languages without them. Those unfamiliar with this kind of programming think of functions as allowing you to generalize operations over data instances.
- Clojure (and all Lisps) allows you to create functions that generalize over processes.
- Clojure has no privileged functions. It doesn't care what the function is or where it came from; it treats all functions the same. 
- Clojure just cares about applying functions
- You don’t have to worry about special rules or syntax for working with different functions.


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


## Abstraction
- Clojure defines map and reduce functions in terms of the *sequence abstraction* not in terms of specific data structures.
- As long as a data structure responds to the **core sequence operations** (the **functions first , rest , and cons**), it will work with map , reduce , and other sequence functions. **??**
- The three functions **define** the sequence abstraction.
- abstractions could be thought as named collections of operations.
- If you can perform all of an abstraction’s operations on an object, then that object is an instance of the abstraction.
- For example, the battery abstraction includes the operation “connect a conducting medium to its anode and cathode,” and the operation’s output is electrical current. It doesn’t matter if the battery is made out of lithium or out of potatoes. It’s a battery as long as it responds to the set of operations that define battery.

## MAP
- Similarly, map doesn’t care about how lists, vectors, sets, and maps are implemented. It only cares about whether it can perform sequence operations on them.
- map essential behavior is to derive a new sequence Y from an existing sequence X using a function F such that 
> y1 = ƒ(x1), y2 = ƒ(x2), . . . yn = ƒ(xn).

- The term sequence here refers to a collection of elements organized in linear order.
- a linear order **is not** an unordered collection or a graph without a before-and-after relationship between its nodes.
- Absent from this description of mapping and sequences is any mention of lists, vectors, or other concrete data structures. Clojure is designed to allow us to think and program in such abstract terms as much as possible, and it does this by implementing functions in terms of data structure abstractions. like **map**, it is defined in terms of the sequence abstraction 


## Indirection 
- In programming, indirection is a generic term for the mechanisms a language employs so that one name can have multiple, related meanings.
- In the case of Clojure, the name first has multiple, data structure–specific meanings.
- Indirection is what makes abstraction possible.


## Ploymorphism
- Polymorphism is one way that Clojure provides indirection.
- polymorphic functions dispatch to different function bodies based on the type of the argument supplied. (It’s not so different from how multiple-arity functions dispatch to different function bodies based on the number of arguments you provide.)
- Clojure has two constructs for defining polymorphic dispatch: the **host platform’s interface construct** and **platform-independent protocols**.


# Errors
- *cannot be cast to clojure.lang.IFn* just means that you’re trying to use something as a function when it’s not.
- *class java.lang.Long cannot be cast to class clojure.lang.IFn* means a number is being used where a function is expected.
> I was using the take function like this (take(arg1 arg2)) where in fact i should use it like this (take arg1 arg2)
- Parenthesis in Clojure are not a grouping construct, they are used primarily to invoke function calls.
- 