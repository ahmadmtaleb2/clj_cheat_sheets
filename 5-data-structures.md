# Data Structures
- All of Clojure’s data structures are **immutable**, meaning you can’t change them in place

## Numbers
- integer => 93
- float => 1.2
- ration => 1/5

## Strings
- Strings represent text => "string"
- Clojure only allows **double quotes** to delineate strings. **'Lord Voldemort' is not a valid string**
- Clojure doesn’t have string interpolation. 
- **concatenation** only via the str function (str "a" "b" "c")

## Maps
- Maps are similar to dictionaries or hashes in other languages.
- They’re a way of associating some value with some other value.
- map values can be of any type—strings, numbers, maps,
vectors, even functions.
- The 2 kinds of maos in Clojure are:
    1. hash maps
    2. sorted maps

### Create map
1. using literal
> empty map => **{}**
2. **hash-map** function 
>(hash-map :a 1 :b 2)

>
>{:first-name "Charlie"
> :last-name "McFishwich"}
>
- in the following we associated "string-key" with the + function:
> 
>{"string-key" +}
>
- maps can be nested
>
>{:name {:first "John" :middle "Jacob" :last "Jingleheimerschmidt"}}


### Look up for values in maps
- You can look up values in maps with the **get** function:
> (get {:a 0 :b 1} :b) ;=> 1
- **get** will return nil if it doesn’t find your key, or you can give it a **default value** to return
> 
> (get {:a 0 :b 1} :c) ;=> nil
> 
> (get {:a 0 :b 1} :c "unicorns?") ;=> "unicorns?"
- The **get-in** function lets you look up values in nested maps:
> (get-in {:a 0 :b {:c "ho hum"}} [:b :c]) ;=> "ho hum"
- Another way to look-up a value in a map is to treat the map like a **function** with the key as its argument:
> ({:name "The Human Coffeepot"} :name) ;=> "The Human Coffeepot"
- Another cool thing you can do with maps is use **keywords** as functions to look up their values

## Keywords
- They’re primarily used as keys in maps
- Keywords can be used as **functions** that look up the corresponding value in a data structure
> (:a {:a 1 :b 2 :c 3}) ;=> 1
- you can provide a default value like get
> (:d {:a 1 :b 2 :c 3} "No gnome knows homes like Noah knows") ; => "No gnome knows homes like Noah knows"
- Using a keyword as a function is pleasantly succinct, and Real Clojurists do it all the time.

## Vectors
- A vector is similar to an **array**, in that it’s a **0-indexed** collection.
- vector elements can be of any type, and you can mix types.

### Create a vector
- vector literal:
> [3 2 1]
- vector function:
> (vector "creepy" "full" "moon") ; => ["creepy" "full" "moon"]
### look up for values
- returning the nth element of a vector 
> (get [3 2 1] 0) ; => 3
>
> (get ["a" {:name "Pugsley Winterbottom"} "c"] 1) ; => {:name "Pugsley Winterbottom"}

### conj
- **conj** function is used to add additional elements to the vector.
- Elements are added to the end of a vector
> (conj [1 2 3] 4) ; => [1 2 3 4]

## Lists
- Lists are similar to vectors in that they’re linear collections of values
- List values can have any type

### Create a list
- list literal:
> '(1 2 3 4) ; => (1 2 3 4)
- list function:
> (list 1 "two" {3 4}) ; => (1 "two" {3 4})

### look up for values
- you **can’t** retrieve list elements with **get**
- to retrieve an element from a list, you can use the nth function:
> (nth '(:a :b :c) 0) ; => :a

### Conj
- **conj** function is used to add additional elements to the list.
- Elements are added to the beginning of a list
> (conj '(1 2 3) 4) ; => (4 1 2 3)

## Notes on List and Vectors
- *it’s good to know that using nth to retrieve an element from a list is slower than using get to retrieve an element from a vector. This is because Clojure has to traverse all n elements of a list to get to the nth, whereas it only takes a few hops at most to access a vector element by its index.*
- **When should you use a list and when should you use a vector?** 
- A good rule of thumb is that if you need to easily add items to the beginning of a sequence or if you’re writing a macro, you should use a list. Otherwise, you should use a vector.

## Sets
- Sets are collections of unique values
- multiple instances of a value become one unique value in the set
- Clojure has two kinds of sets: 
    1. hash sets
    2. sorted sets
### Create a set
- hash set literal:
> #{"kurt vonnegut" 20 :icicle}
- hash-set:
> (hash-set 1 1 2 2) ; => #{1 2}
- from existing vectors and lists by using the set function:
> (set [3 3 3 4 4]) ; => #{3 4}

### Conj
- If you try to add a value to a set that already contains that value it will still have only one of that value

### check if it contains
- check for set membership by using:
    1. **contains?** function which return true or false
    2. **get** return the value if exist or nil if doesn't
    3. a **keyword** as function with the set as its argument -> return the value if exist or nil if doesn't
>
>(contains? #{:a :b} :a) ; => true
>
>(:a #{:a :b}) ; => :a
>
>(get #{:a :b} :a) ; => :a
- using **get** to test whether a set contains nil will always return **nil** , which is confusing. **contains?** may be the better option when you’re testing specifically for set membership.
