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
>
>(defn my-first
>
>    [[first-thing]]
>
>    first-thing)
>
>(my-first ["oven" "bike" "war-axe"])
>
> ;=> "oven" is the result
- what happens is that my-first function associates th symbol firt-thing with the first element of the vector that was passed in as argument.
- this function is going to receive a **list** or **vector** as an argument. Clojure will take apart the argument's structure and associate meaningful names with different parts of the argument.
- when destructuring a vector or list, you can name as many elements as you want and also use **rest parameters**
- the rest parameters handles any number of additional arguments
> (defn chooser
>
>    [[first-choice second-choice & unimportant-choices]]
>
>       (println (str "Your first choice is: " first-choice))
>
>       (println (str "Your second choice is: " second-choice))
>
>       (println (str "We're ignoring the rest of your choices. "
>
>       "Here they are in case you need to cry over them: " (**clojure.string/join ", "** unimportant-choices))))
>   
>   (chooser ["Marmalade", "Handsome Jack", "Pigpen", "Aquaman"])
; => Your first choice is: Marmalade
; => Your second choice is: Handsome Jack
; => We're ignoring the rest of your choices. Here they are in case you need to cry over them: Pigpen, Aquaman

- you can desctruct maps in the same way of destructuring vector or list by providing maps as a parameter **{}**
> 
> (defn treasure-location

>    [{lat :lat lng :lng}] ;; [{:keys[lat lng]}] for shorter syntax
>
>    (println (str "treasure lat: " lat "treasure lng:" lng)))
>
> (treasure-location {:lat 28.22 :lng 81.33})
- [{:keys [lat lng] :as location}] to access the original map argument by :as location 


### function body 
- the function body can contain forms of any kind
- Clojure automatically return the last form evaluated

## anonymous functions 
- In Clojure, functions don’t need to have names
- You can treat fn nearly identically to the way you treat defn . The parameter lists and function bodies work exactly the same. You can use argument destructuring, rest parameters, and so on.
- you could associate the anonymous function with a name like (def multiplier (fn [x] (* x 3)))

### create an anonymous function 
1. **fn** form
> (fn 
>
> [param-list]
>
> function-body)
2. more compact way; the percent sign, % , indicates the argument passed to the function. If your anonymous function takes multiple arguments, you can distinguish them like this: %1 , %2 , %3 , and so on. % is equivalent to %1
> (#(str %1 " and " %2) "cornbread" "butter beans")
>
> output: "cornbread and butter beans"
- we can pass a rest parameter with **%&**
> (#(identity %&) 1 "blarg" :yip)
>
> output: (1 "blarg" :yip)

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

## returning functions 
- functions can return other functons.
- The returned
functions are closures, which means that they can access all the variables that were in scope when the function was created.
> (defn inc-maker
>
>    "create a custom incrementor"
>
>    [inc-by]
>
>    #(+ % inc-by))
>
> (def inc3 (inc-maker 3))
>
>(inc3 7)
> output: 10 *inc-by is in scope, so the returned function has access to it even when the returned function is used outside inc-maker* **didn't understand**

## rest arguments
- rest arguments are store as lists, so the function application returns a list of all the arguments

