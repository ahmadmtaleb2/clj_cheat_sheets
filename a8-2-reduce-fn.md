## REDUCE function 

> (reduce f coll) or (reduce f val coll)
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
- reduce could be used to transform a map’s values, producing a new map with the same keys but with updated values:
> (reduce (fn [new-map [key val]]
>    (assoc new-map key (inc val)))
>    {}
>    {:max 30 :min 10})
> => output: {:max 31, :min 11}
- reduce could be used to filter out keys from a map based on their value
> (reduce
    (fn [new-map [key val]]
    (if(> val 4)
        (assoc new-map key val)
        new-map)) {} {:a 4.1 :b 3.9 :c 50})
> => output: {:a 4.1 :c 50}