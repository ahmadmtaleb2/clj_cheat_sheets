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