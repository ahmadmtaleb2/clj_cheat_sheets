# MAP function 

## How it works under the hood 
- Similarly, map doesn’t care about how lists, vectors, sets, and maps are implemented. It only cares about whether it can perform sequence operations on them.
- map essential behavior is to derive a new sequence Y from an existing sequence X using a function F such that 
> y1 = ƒ(x1), y2 = ƒ(x2), . . . yn = ƒ(xn).

- The term sequence here refers to a collection of elements organized in linear order.
- a linear order **is not** an unordered collection or a graph without a before-and-after relationship between its nodes.
- Absent from this description of mapping and sequences is any mention of lists, vectors, or other concrete data structures. Clojure is designed to allow us to think and program in such abstract terms as much as possible, and it does this by implementing functions in terms of data structure abstractions. like **map**, it is defined in terms of the sequence abstraction 


- The map function takes two arguments: 
    1. a function (f) and 
    2. a sequence (s). 
- **map** creates a new list by applying a function to each member of a collection 
- **map** doesn't return a vector, even if we supplied a vector as an argument
- map allows you to generalize the process of transforming a collection by applying a function—any function—over any collection.
> (map inc [0 1 2 3]) => output: (1 2 3 4)

- When you pass map multiple collections, the elements of the first collection will be passed as the first argument of the mapping function, the elements of the second collection will be passed as the second argument, and so on.

- Just be sure that your mapping function can take a number of arguments equal to the number of collections you’re passing to map. like **str** in the following example
> (map str ["a" "b" "c"] ["A" "B" "C"])     => output: ("aA" "bB" "cC")

- another example of how we can apply map to more than one argument 

> (def human-c [8.1 7.3 6.6 5.0]) // we are binding the vector of decimal values to human-c => so, human-c hold the value of the vector of values
> 
> (def critter-c [0.0 0.2 0.3 1.1]) // same as the previous step
>
> (defn unify-diet [human critter] {:human human :critter critter}) // this function aims to have two arguments and return a map thak contains the keywords :human and :critter with the assigned value passed by arguments => human and critter could not passed as vector => we aim to pass them a value by value => so for this reason we'll gonna use map in order to return a sequence where all the couple values are grouped as a collection of maps 
>
> (map unify-diet human-c critter-c)        => output: ({:human 8.1 :critter 0.0} {:human 7.3 :critter 0.2} {:human 6.6 :critter 0.3} {:human 5.0 :critter 1.1})


- you can pass to map a collection of functions
> (def sum #(reduce + %))
>
> (def avg #(/ (sum %) (count %)))
>
> (defn stats [numbers] (map #(% numbers) [sum count avg])) // the stats function iterates over a vector of functions applying each function to number => the first iteration we are applying sum to numbers, the second count and the third avg
> 
> (stats [3 4 10])      => output: (17 3 17/3)
>
> (stats [80 1 44 13 6])        => output: (144 5 144/5) // the stats returned a sequence of the sum count and avg 

- you can use map to retrieve the value associated with a keyword from a collection of map data structures. (because keywords can be used as functions!)
> (def identities
>    [{:a "batman" :b "bruce"} {:a "spider man" :b "peter"} {:a "super man" :b "Kal-El"}])
>
> (map :b identities)       => output: ("bruce" "peter" "kal-El")