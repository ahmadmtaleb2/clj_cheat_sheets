# Functions dictionary 
it is a document that group all the functions that I encountered so far


## filter 
- a seq function  
- The filter function takes two arguments: 
    1. a predicate function (f) and 
    2. a sequence (s). 
- Filter returns a new sequence consisting of all the items of s for which (f item) returns true.
- Returns a transducer when no collection is provided.
- pred must be free of side-effects.
> (filter pred)     (filter pred coll)
>
> (filter #(> % 5) '(3 4 5 6 7)) => output: (6 7)
>
>(filter even? (range 10)) => output: (0 2 4 6 8)
>
> (filter (fn [x] (= (count x) 1)) ["a" "aa" "lisp" "clojure" "q" ""]) => output: ("a" "q")
>

## some
- Returns the first logical true value of (pred x) for any x in coll, else nil.  
- One common idiom is to use a set as pred, for example
this will return :fred if :fred is in the sequence, otherwise nil:
> (some #{:fred} coll)
>
> (some pred coll)
>
> (some even? (1 2 3 4))        => output: true
>
> (some even? '(1 3 5 7))       => output: nil
>
> (def values [0 1 2 3 4 5 6])
>
> (some #(and (< % 6) %) values)        => output: 0
>
> (some #(and (> % 6) %) values)        => output: nil
>
> (some #(and (< % 3) %) values)        => output: 0 // we are using and in order to show the value from values that evaluates the predicate function of some to true => so as a result, some will not return true or false instead it will returns the value 


## sort
- it sorts elements in ascending order 
- Returns a sorted sequence of the items in coll. 
- If no comparator is supplied, uses compare.
- comparator must implement java.util.Comparator
- Guaranteed to be stable: equal elements will not be reordered.
- If coll is a Java array, it will be modified.  To avoid this, sort a copy of the array.

> (sort coll)       (sort comp coll)
>
> (sort [3 1 2 4])      => output: (1 2 3 4)
>
> (sort > (vals {:foo 5, :bar 2, :baz 10}))     => output: (10 5 2)
>

## sort-by
- allows you to apply a function (sometimes called a key function) to the elements of a sequence and use the values it returns to determine the sort order.
- Returns a sorted sequence of the items in coll, where the sort order is determined by comparing (keyfn item). 
- If no comparator is supplied, uses compare. 
- comparator must implement java.util.Comparator. Guaranteed to be stable: 
- equal elements will not be reordered.
- If coll is a Java array, it will be modified. To
avoid this, sort a copy of the array.
> (sort-by keyfn coll)      (sort-by keyfn comp coll)
>
> (sort-by count ["aaa" "bb" "c"])      => output: ("c" "bb" "aaa")
>
> (sort-by first [[1 2] [2 2] [2 3]])       => output: ([1 2] [2 2] [2 3])
>
> (sort-by first > [[1 2] [2 2] [2 3]])     => output: ([2 2] [2 3] [1 2])
>

## concat
- concat simply appends the members of one sequence to the end of another
- Returns a lazy seq representing the concatenation of the elements in the supplied colls.
> (concat [1 2] [3 4])      => output: (1 2 3 4)
>
> (into [] (concat [1 2] [3 4]))        => output: [1 2 3 4]
>
> (concat [:a :b] nil [1 [2 3] 4])      => output: (:a :b 1 [2 3] 4)
>
> (concat "abc" "def")      => output: (\a \b \c \d \e \f)


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
- a seq function 
- it takes two arguments:
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
- a seq function 
- it takes a predicate funtion => **pred** => a function whose return value is evaluated for truth or flasity to determine when it should stop taking.
-  Returns a lazy sequence of successive items from coll **while** (pred item) returns logical **true**. 
- pred must be free of side-effects.
- Returns a transducer when no collection is provided.
- When take-while start, if the anonymous function reaches an entry that returns false => take-while returns a sequence of every element it tested
until that point and if it is the first element it will return a transducer **()**.

> (take-while pred) **OR** (take-while pred coll)
>
> (def months [{:month 1 :name "january"} {:month 2 :name "february"} {:month 3 :name "march"} {:month 4 :name "april"} {:month 5 :name "may"} {:month 6 :name "juin"} {:month 7 :name "july"} {:month 8 :name "august"} {:month 9 :name "september"} {:month 10 :name "october"} {:month 11 :name "november"} {:month 12 :name "december"}])
>
> (take-while #(> (:month %) 3) months)     => output: () // the first month is 1, it is less than 3 so the function is ealuated to false so it didn't continue 
>
> (take-while #(< (:month %) 3) months)     => output: ({:month 1, :name "january"} {:month 2, :name "february"})
>
> (take-while #(= (rem (:month %) 3) 1) months)     => output: ({:month 1 :name "january"})
>
> (take-while #(= (rem (:month %) 3) 0) months)     => output: ()
>
> (take-while #(= (rem (:month %) 2) 1) months)     => output: ({:month 1 :name "january"})
>
> (take-while #(= (rem (:month %) 2) 0) months)     => output: ()

## drop 
- a seq function 
- it take two arguments:
    1. a number n
    2. a collection coll
- Returns a lazy sequence with the first n items in coll **removed**
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


## drop-while
- a seq function 
- the same ideas that applies to take-while applies to drop-while 
- BUT it keeps dropping elements until the test return false (in the pred function)
- Returns a lazy sequence of the items in coll starting from the first item for which (pred item) returns logical false.  Returns a
stateful transducer when no collection is provided.
> (drop-while pred)     (drop-while pred coll)
>
> (drop-while neg? [-1 -2 -3 1 -2 4 6 7 8 9 -1])        => output: (1 -2 4 6 7 8 9 -1)
>
> (drop-while #(> 3 %) [1 2 3 4 5 6])       => output: (3 4 5 6)
>
> (drop-while #(> 3 %) [5 3 1 2 3 4 5 6])       => output: (5 3 1 2 3 4 5 6)
>

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

# rem
- remainder of dividing numerator by denominator.
> (rem num div)

## odd
- Returns true if n is odd, 
- throws an exception if n is not an integer
> (odd? n)
>
> (odd? 1)      => output: true
>
> (odd? 2)      => output: false
>
> (odd? 0)      => output: false

## even
- Returns true if n is even, 
- throws an exception if n is not an integer
> (even? n)
>
> (even? 1)      => output: false
>
> (even? 2)      => output: true
>
> (even? 0)      => output: true



## range
- it returns a lazy seq of nums from start (**inclusive**) to end (**exclusive**), by step, where start defaults to 0, step to 1, and end to infinity.
- When step is equal to 0, returns an infinite sequence of start. 
- When start is equal to end, returns empty list.
> (range)
>
> (range end)
>
> (range start end)
>
> (range start end step)
>
> (range 10)        => output: (0 1 2 3 4 5 6 7 8 9)
>
> (range -5 5)      => output: (-5 -4 -3 -2 -1 0 1 2 3 4)
>
> (range 0 6 2)     => output: (0 2 4)
>
> (range 100 0 -10)     => output: (100 90 80 70 60 50 40 30 20 10)


## time 
- Evaluates expr and prints the time it took.  Returns the value of expr.
> (time expression)
> 
> (time (concat '(1 2) '(3 4)))     => output: "Elapsed time: 0.066739 msecs"  (1 2 3 4)


## 