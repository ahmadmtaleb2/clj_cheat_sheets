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

- Clojure uses whitespace to separate operands, and it treats commas as whitespace. NO COMMAS!.
- the **+** operator adds the operrands 
- the **str** operator concatenates strings to form a new string 
- Clojure’s support for first-class functions allows you to build more power­ful abstractions than you can in languages without them. Those unfamiliar with this kind of programming think of functions as allowing you to generalize operations over data instances.
- Clojure (and all Lisps) allows you to create functions that generalize over processes.
- Clojure has no privileged functions. It doesn't care what the function is or where it came from; it treats all functions the same. 
- Clojure just cares about applying functions
- You don’t have to worry about special rules or syntax for working with different functions.
- *in any LISP language, code is just data (or more specifically, code is a subset of data that conforms to a language spec)*. 
- the ; in Clojure creates a comment to the end of the line 
- Clojure is a homoiconic language, which is a term describing the fact that Clojure programs are represented by Clojure data structures 
- Clojure is defined in terms of the evaluation of data structures and not in terms of the syntax of character streams /files 
- Most Clojure forms evaluate to themseleves, except **symbols** and **lists**
- Symbols are used to refer to something else and when evaluated return what they refer to 
- Lists are evaluated as invocation 
    - for the previous mentioned reasons, you can use single quote to suspend evaluation => So, symbols are symbol without looking up what it refers to => and list are a list of data values and not code to be evaluated 
    > 'x        => output: x 
    >
    > '(1 2 3)
- In Clojure, everything is an expression that evaluates to a value. Some expression also have side effects


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

## Clojure Reader
- most Clojure prgrams begin life as text files
- it is the reader's task to parse the text and produce the data structure for the compiler to see 
- this is not a phase of the compiler 
- The reader is represented by the function **read**, which reads the next **form** (not character) from a stream, and returns the object represented by that form.
- the reader may read the source either from .clj or be given a series of expressions interactively 
- the reader produces Clojure data 
- the clojure compiler then produces the bytecode for the JVM. 
- the unit of source code is a Clojure expression, not a Clojure source file 
- Source files are read as a series of expressions, just as if you typed those expression interactively at the REPL
- Separating the reader and the compiler is a key separation that makes room for macros. Macros are special functions that take code (as data) amd emit code (as data)

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

### Collection Abstraction 
- The collection abstraction is closely related to the sequence abstraction. All of Clojure’s core data structures (vectors, maps, lists, and sets) take part in both abstractions.
- The sequence abstraction is about operating on members individually, whereas the collection abstraction is about the data structure as a whole.
- the collection functions count , empty? , and every? aren’t about any individual element; they’re about the whole


## Indirection 
- In programming, indirection is a generic term for the mechanisms a language employs so that one name can have multiple, related meanings.
- In the case of Clojure, the name first has multiple, data structure–specific meanings.
- Indirection is what makes abstraction possible.


## Ploymorphism
- Polymorphism is one way that Clojure provides indirection.
- polymorphic functions dispatch to different function bodies based on the type of the argument supplied. (It’s not so different from how multiple-arity functions dispatch to different function bodies based on the number of arguments you provide.)
- Clojure has two constructs for defining polymorphic dispatch: the **host platform’s interface construct** and **platform-independent protocols**.

# what is a pure function?? println and rand aren't pure function??
- look up for this 

# Functional programming
- Going beyond immediately practical concerns, the differences between the way you write object-oriented and functional code point to a deeper difference between the two mindsets. 
- Programming is about manipulating data for your own purposes. 
    1. In OOP, you think about data as something you can embody in an object, and you poke and prod it until it looks right. During this process, your original data is lost forever unless you’re very careful about preserving it. 
    2. By contrast, in functional programming you think of data as unchanging, and you derive new data from existing data.
## pure functions
- a function is pure if it meets 2 qualifications:
    1. it always returns the same result if given the same arguments => this is called **referential transparency**
    2. it can't cause any **side effects** => which means that the function can't make any changes that are observable outside the function itself => for example, by changing an externally accessible mutuable object or writing to a file 
- they are completely isolated, unable to impact other parts of the system => there is no need to ask "What could I break by calling this function?"
- they are consistent => you'll never need to figure out why passing a function the same arguments results in different return values => it will never happen 
- they are stable and problem free

### referentially transparent 
- return the same result when called with the same argument 
- pure functions rely on 
    1. their own arguments 
    2. immutable values to determine their return value 
- any function that relies on a random number generator cannot be referentially transparent 
- if a function reads from a file, it's not referentially transparent because the file's contents can change 
- When using a referentially transparent function, you never have to consider what possible external conditions could affect the return value of the function. This is especially important if your function is used multiple places or if it’s nested deeply in a chain of function calls. In both cases, you can rest easy knowing that changes to external conditions won’t cause your code to break.
- Another way to think about this is that reality is largely referentially transparent. If you think of gravity as a function, then gravitational force is the return value of calling that function on two objects.

### side effects
- To perform a side effect is to change the association between a name and its value within a given scope
- Side effects are potentially harmful, however, because they introduce uncertainty about what the names in your code are referring to.
- When calling a function that doesn’t have side effects, you only have to consider the relationship between the input and the output. You don’t have to worry about other changes that could be rippling through your system.
- Clojure limit side effects of its core data structures by its immutability.

## Immutable data structures
### recursion 
- it is you functional way to iterate over some collection to build a result 
- Clojure has no assignment operator
- you can't associate a new value with a name without creating a new scope
> (def baby-name "oleg") // you first bind the name baby-name to the value "oleg" within the global scope
>
> baby-name     => output: "oleg"
>
> (let [baby-name "sasha"] baby-name)       => output: "sasha" // a new scope is introduced with let. So, within this scope you bind baby-name to "sasha"
>
> baby-name         => output: "oleg" // Once Clojure finishes evaluating the let expressionm you're back in the global scope and baby-name is evaluated to "oleg" once again 

- each recursive call creates a new scope where arguments are bound to different values, all without the needing to alter the values originally passed to the function or perform any internal mutation
- you should use **recur** when doing recursion for performance reasons (Clojure doesn't provide tail call optimization)
> (defn sum
    ([vals] (sum vals 0))
    ([vals accumulating-total]
    (if empty? vals)
        accumulating-total
        (recur (rest vals) (+ (first vals) accumulating-total))))
>
- Using recur isn’t that important if you’re recursively operating on a small collection, but if your collection contains thousands or millions values, you will definitely need to whip out recur so you don’t blow up your program with a stack overflow.
- Clojure’s immutable data structures are implemented using structural sharing => It’s kind of like Git!

### Composition
- function composition is the process of combining functions so that the return value of one function is passed as an argument to another
> (require '[Clojure.string :as s])  // we use reauire to access the string function library
>
> (defn clean [text] (s/replace (s/trim text) #"lol" "LOL"))  // the clean function works by passing an immutable value "text" to a pure function trim which returns an immutable value where the spaces at the start and end are trimmed => that value is then passed to the pure function replace which returns another immutable value after replacing the target sub-string with a new one
>
> (clear "my blah is so lol!     ")     => output: "my blah is so LOL!"  // clean function will work on any string by 1. decoupling functions and data 2. programming to a small set of abstractions 

- function composition isn't so different from recursion => recursion continually passes the result of a function to another function (the same function)

## Note
- To get the most from Clojure, try to keep your impure functions to a minimum. In an immutable world, you use recursion instead of for / while loops, and function composition instead of successions of mutations. Pure functions allow powerful techniques like function composition functions and memoization.


# Errors
- *cannot be cast to clojure.lang.IFn* just means that you’re trying to use something as a function when it’s not.
- *class java.lang.Long cannot be cast to class clojure.lang.IFn* means a number is being used where a function is expected.
> I was using the take function like this (take(arg1 arg2)) where in fact i should use it like this (take arg1 arg2)
- Parenthesis in Clojure are not a grouping construct, they are used primarily to invoke function calls.
