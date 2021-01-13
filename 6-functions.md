# Functions 

## Defining functions
- function definitions are composed of five main parts:
    1. defn
    2. function name
    3. a docstring describing the function (optional)
    4. parameters listed in brackets
    5. function body
>
>(defn too-enthusiastic
>   "return a cheer that might be a bit to enthousistic"
>   [name]
>   (str "Oh ,u god!" name " you are most definitely the best"!))

### Doctring
- The docstring is a useful way to describe and document your code. 
- You can view the docstring for a function in the REPL with (doc fn-name) —for example, (doc map). 
- The docstring also comes into play if you use a tool to generate documentation for your code.

### Parameters and Arity
- Clojure functions can be defined with zero or more parameters.
- The values you pass to functions are called arguments, and the arguments can be of any type.
- no-params is a 0-arity function, one-param is 1-arity, and two-params is 2-arity.
> (defn no-params 
>    []
>    "I take no parameters!")
>
> (defn one-param
>    [x]
>    (str "I take one parameter" x))
>
> (defn two-params
>    [x y]
>    (str "two params!" x y))

- Functions also support **arity overloading**. This means that you can define a function so a different function body will run depending on the arity.
> (defn multi-arity
>
>    ;; 3-arity arguments and body
>    ([first-arg second-arg third-arg]
>        (do-things first-arg second-arg third-arg))
>
>    ;; 2-arity arguments and body
>    ([first-arg second-arg]
>        (do-things first-arg second-arg))
>
>    ;; 1-arity argument and body
>    ([first-arg]
>        (do-things first-arg)))

- you can define a function in terms of itself like the following
> (defn x-chop
>    "describe the kind of chop you're inflicting on someone"
>    ([name chop-type]
>        (str "I" chop-type "chop" name "!")
>    )
>    ([name]
>    (x-chop name "karate")))
- "karate" is the default value of chop-type
- you can also make each arity do something completely unrelated

- Clojure also allows to define variable-arity functions by including a **rest parameter** as in "put the rest of these arguments in a list with the following name"
- the rest parameter is indicated by an ampersand **&**
> (defn codger-communication
>    [whippersnapper]
>    (str "get of my lawn, " whippersnapper))
>
>   (defn codger
>    [&whippersnapper]
>    (map codger-communication whippersnapper))

- You can mix rest parameters with normal parameters, but the rest parameter has to come last


### Destructuring
- The basic idea behind destructuring is that it lets you concisely bind names to values within a collection
- 


### function body 
- the function body can contain forms of any kind
- Clojure automatically return the last form evaluated

## anonymous functions 
- In Clojure, functions don’t need to have names

### create an anonymous function 
1. **fn** form
2. 
> (fn 
> [param-list]
> function-body)
>
>


## calling functions 
- **Function call** is just another term for an operation where the operator is a function or a function expression (an expression that returns a function).
- operation = (operator operand1 operand2 ... operand n)
- functions can take any expressions as arguments—including  other functions.
- Functions that can either take a function as an argument or return a function are called higher-order functions.
- Programming languages with higher-order functions are said to support first-class functions because you can treat functions as values in the same way you treat more familiar data types like numbers and vectors.
- **Clojure evaluates all function arguments recursively before passing them to the function.**


## special forms
- special forms are unlike function calls, they don't always evaluate all of their operands
- you can’t use them as arguments to functions
- special forms implement core Clojure functionality that just can’t be implemented with functions
- 

## macro calls 
- Macros are similar to special forms in that they evaluate their operands differently from function calls, and they also can’t be passed as arguments to functions.


## map function
- **map** creates a new list by applying a function to each member of a collection 
- **map** doesn't return a vector, even if we supplied a vector as an argument
- map allows you to generalize the process of transforming a collection by applying a function—any function—over any collection.

## inc function
- **inc** function increments a number by 1

>(inc 1.1) ;=? 2.1
>
>(map inc [0 1 2 3]) ;=> (1 2 3 4)

