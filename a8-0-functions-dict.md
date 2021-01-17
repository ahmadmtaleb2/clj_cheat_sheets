# Functions dictionary 
it is a document that group all the functions that I encountered so far


## filter  
- The filter function takes two arguments: 
    1. a predicate function (f) and 
    2. a sequence (s). 
- Filter returns a new sequence consisting of all the items of s for which (f item) returns true.
- Returns a transducer when no collection is provided.

> (filter #(> % 5) '(3 4 5 6 7)) => output: (6 7)
>
>(filter even? (range 10)) => output: (0 2 4 6 8)
>
> (filter (fn [x] (= (count x) 1)) ["a" "aa" "lisp" "clojure" "q" ""]) => output: ("a" "q")

## count  
- Returns the number of items in the collection. 
- (count nil) returns 0.
- Also works on strings, arrays, and Java Collections and Maps
> (count coll)
> 
> (count nil) => output: 0
>
> (count []) => output: 0
> (count [1 2 3]) => output: 3
>
> (count {:one 1 :two 2}) => output: 2
>
> (count [1 \a "string" [1 2] {:foo :bar}]) => output: 5
> 
> (count "string") => output: 6


## dec 
- Returns a number one less than x. 
- Does not auto-promote longs, will throw on overflow
> (dec x)
>
> (dec 2) => output: 1
>
> (dec 2.0) => output: 1.0
>
> (dec 1) => output: 0
>
> (dec -1)  => output: -2


## nth
- Returns the value at the index. 
- get returns nil if index out of bounds, 
- nth throws an exception unless not-found is supplied.
- nth also works for strings, Java arrays, regex Matchers and Lists, and, in O(n) time, for sequences.
> (nth coll index) **OR** (nth coll index not-found)
>
> (nth ["a" "b" "c" "d"] 0) => output: "a"
>
> (nth ["a" "b" "c" "d"] 1) => output: "b"
>
> (nth [] 0) => output: IndexOutOfBoundsException
>
> (nth [] 0 "nothing found") => output: "nothing found"
>
> (nth [0 1 2] 77 1337) => output: 1337


## inc 
- **inc** function increments a number by 1
>(inc 1.1) => output: 2.1


## identity  
- the identity function returns the argument it's given without altering it.
> (identity 4) => output: 4


## take
- it take two arguments:
    1. a number n
    2. a collection coll
- Returns a lazy **sequence** of the first n items in coll
- or all items if there are fewer than n.
- Returns a stateful transducer **()** when no collection is provided.
- 
> (take n) **OR** (take n coll)
>
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


## take-while
- take-while traverses the given sequence (in this case, food-journal ), applying the predicate function to each element.
-  Returns a lazy sequence of successive items from coll while (pred item) returns logical true. pred must be free of side-effects.
- Returns a transducer when no collection is provided.
> (take-while pred) **OR** (take-while pred coll)
>
> 

## drop 
- it take two arguments:
    1. a number n
    2. a collection coll
- Returns a lazy sequence with the first n items in coll removed
- Returns a stateful transducer **()** when no collection is provided.
> (drop n) **OR** (drop n coll)
> 
> (drop -1 [1 2 3 4]) => output: (1 2 3 4) `negative (or zero) drop-item-counts are accepted they do nothing`
>
> (drop 0 [1 2 3 4]) => output: (1 2 3 4) 
>
> (drop 2 [1 2 3 4]) => output: (3 4)
>
> (drop 5 [1 2 3 4]) => output: () `dropping more items than are present is allowed, and all items are dropped`



## into
> (into *to* *from*)
- add the element in the from to the element in to
> (into [] (set [:a :a])) => output: [:a] 


## loop
- loop defines bindings
- recur **re-executes** loop with new bindings
> (loop [i 0]
    (if(< i 10)
        (recur (inc i))
        i))
- On the first pass through the loop, i has a value of 0. Next, it checks the value of i. If the value is less than 10 we recur . It’s as if loop creates an anonymous function with a parameter named i , and recur allows you to call the function from within itself, passing the argument (inc i).


## re-find
- re-find checks whether a string matches the pattern described by a regular expression
- it returns the **matched text** or **nil** if there is no match
> (re-find #"^left-" "left-eye") => output: "left-"
> (re-find #"^left-" "wongleblart")) => output: nill


## empty?
- Returns true if **coll** has no items 
> (empty? coll)
>
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


## first, second and last
- All Clojure collections support sequencing. You can operate on sequences with functions like first, second, and last.
> (= 3 (first '(3 2 1))) => output: true
>
> (= 3 (second [2 3 4])) => output: true
>
> (= 3 (last (list 1 2 3))) => output: true


## rest
- The rest function will return all the items of a sequence except the first.
> (= [20 30 40] (rest[10 20 30 40]))


## seq 
- find it in the sequences file
