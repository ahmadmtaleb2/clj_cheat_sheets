# Maps

- Maps are similar to dictionaries or hashes in other languages.
- They’re a way of associating some value with some other value.
- map values can be of any types: strings, numbers, maps, vectors, even functions.
- The 2 kinds of maps in Clojure are:
    1. hash maps
    2. sorted maps

## Create map
1. using literal
> empty map => **{}**
>
>{:first-name "Charlie" :last-name "McFishwich"}

2. **hash-map** function 
>(hash-map :a 1 :b 2)

- in the following we associated "string-key" with the + function:
>{"string-key" +}
>
- maps can be nested:
>{:name {:first "John" :middle "Jacob" :last "Jingleheimerschmidt"}}


## Look up for values in maps
- You can look up values in maps with the **get** function:
> (get {:a 0 :b 1} :b)      =>  output: 1
- **get** will return nil if it doesn’t find your key, or you can give it a **default value** to return
> (get {:a 0 :b 1} :c)      => output: nil
> 
> (get {:a 0 :b 1} :c "unicorns?")      => output: "unicorns?" //default value


- The **get-in** function lets you look up values in nested maps:
> (get-in {:a 0 :b {:c "ho hum"}} [:b :c])      => output: "ho hum"

- Another way to look-up a value in a map is to treat the map like a **function** with the key as its argument:
> ({:name "The Human Coffeepot"} :name)     => output: "The Human Coffeepot"
- Another cool thing you can do with maps is use **keywords** as functions to look up their values
> (:name {:name "The Human Coffeepot" :des "blah"})     => output: "The Human Coffeepot"

