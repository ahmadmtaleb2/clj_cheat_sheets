# MAP function 

- The map function takes two arguments: 
    1. a function (f) and 
    2. a sequence (s). 
- **map** creates a new list by applying a function to each member of a collection 
- **map** doesn't return a vector, even if we supplied a vector as an argument
- map allows you to generalize the process of transforming a collection by applying a function—any function—over any collection.
> (map inc [0 1 2 3]) => output: (1 2 3 4)

- When you pass map multiple collections, the elements of the first collection will be passed as the first argument of the mapping function, the elements of the second collection will be passed as the second argument, and so on.

- Just be sure that your mapping function can take a number of arguments equal to the number of collections you’re passing to map. like **str** in the following example
> (map str ["a" "b" "c"] ["A" "B" "C"]) => output: ("aA" "bB" "cC")

- you can pass to map a collection of functions
> (def sum #(reduce + %))
>
> (def avg #(/ (sum %) (count %)))
>
> (defn stats [numbers] (map #(% numbers) [sum count avg]))
> 
> (stats [3 4 10]) => output: (17 3 17/3)
>
> (stats [80 1 44 13 6]) => output: (144 5 144/5)

- you can use map to retrieve the value associated with a keyword from a collection of map data structures. (because keywords can be used as functions!)
> (def identities
>    [{:a "batman" :b "bruce"} {:a "spider man" :b "peter"} {:a "super man" :b "Kal-El"}])
>
> (map :b identities)
