# Functions dictionary 
it is a document that group all the functions that I encountered so far

## map function
- **map** creates a new list by applying a function to each member of a collection 
- **map** doesn't return a vector, even if we supplied a vector as an argument
- map allows you to generalize the process of transforming a collection by applying a function—any function—over any collection.

## inc function
- **inc** function increments a number by 1

>(inc 1.1) ;=? 2.1
>
>(map inc [0 1 2 3]) ;=> (1 2 3 4)

## identity function 
- the identity function returns the argument it's given without altering it.
> (identity 4) => output: 4

## take
> (take n)
>
> (take n coll)
- Returns a lazy sequence of the first n items in coll, or all items if there are fewer than n.
- Returns a stateful transducer **()** when no collection is provided.
- Examples:
> (take 3 '(1 2 3 4 5)) => output: (1 2 3)
>
> (take 3 [1 2]) => output: (1 2) returns all items if there are fewer than n
>
> (take 1 []) => output: ()
>
> (take 1 nil) => output: ()
>
> (take 0 [1]) => output: ()
>
> (take -1 [1]) => output: ()

## into
> (into *to* *from*)
- add the element in the from to the element in to
> (into [] (set [:a :a]))
>
> output: [:a] 

## loop
- loop defines bindings
- recur **re-executes** loop with new bindings
> (loop [i 0]
>
>    (if(< i 10)
>
>        (recur (inc i))
>
>    i))
- On the first pass through the loop, i has a value of 0. Next, it checks the value of i. If the value is less than 10 we recur . It’s as if loop creates an anonymous function with a parameter named i , and recur allows you to call the function from within itself, passing the argument (inc i).


## re-find
- re-find checks whether a string matches the pattern described by a regular expression
- it returns the **matched text** or **nil** if there is no match
> (re-find #"^left-" "left-eye")
>
> output: "left-"
> (re-find #"^left-" "wongleblart"))
>
> output: nill

## reduce
> (reduce f coll)
>
> or
>
> (reduce f val coll)
- **f** should be a function of 2 arguments. 
- **val** is an optional initial value

- If **val** is not supplied:
    1. returns the result of applying **f** to the first 2 items in coll
    2. then applying **f** to that result and the 3rd item, etc.
    - If **coll** contains no items, **f** must accept no arguments as well, and reduce returns the result of calling f with no arguments.  
    - If **coll** has only 1 item, it is returned and **f** is not called.

- If **val** is supplied:
    1. returns the result of applying **f** to **val** and the first item in **coll**
    2. then applying **f** to that result and the 2nd item, etc. 
    - If **coll** contains no items, returns **val** and **f** is not called.
- reduce takes a collection of elements, i.e. [1 2 3 4], and returns a single number. 
- you can also use reduce to return an even larger collection than the one you started with
- reduce abstracts the task "process a collection and build a result"


## empty?
> (empty? coll)
- Returns true if **coll** has no items 
> (empty? ()) => output: true
>
> (empty? []) => output: true
>
> (empty? {}) => output: true
>
> (empty? "") => output: true
>
> (empty? nil) => output: true


## expand (form)
- didn't find this one 

## 