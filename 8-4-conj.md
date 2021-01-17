# CONJ

> (conj coll x)     (conj coll x & xs)
- conj[oin] =>  Returns a new collection with the xs 'added'. 
- (conj nil item) returns (item).  
- The 'addition' may happen at different 'places' depending on the concrete type.


- **conj** function is used on **vector** to add additional elements to the vector.
- Elements are added to the end of a vector
> (conj [1 2 3] 4) ; => [1 2 3 4]
>
> (conj ["a" "b" "c"] "d")      => output: ["a" "b" "c" "d"]
>
> (conj [1 2] 3 4)      => output: [1 2 3 4]  // conjoining multiple items is done in order
>
> (conj [[1 2] [3 4]] [5 6])        => output: [[1 2] [3 4] [5 6]]


- **conj** function is used on **list** to add additional elements to the list.
- Elements are added to the beginning of a list
> (conj '(1 2 3) 4) ; => (4 1 2 3)
>
> (conj '(1 2) 3 4)     =>  output: (4 3 1 2) // conjoining multiple items is done in order

- **conj** on maps only take items as vectors of length exactly 2 or a map with unlimited number of elements 
> (conj {1 2, 3 4} [5 6])       => output: {5 6, 1 2, 3 4}
>
> (conj {:firstname "John" :lastname "Doe"} {:age 25 :nationality "Chinese"})       => output: {:firstname "John", :lastname "Doe", :age 25, :nationality "Chinese"}

- **conj** on a set
- If you try to add a value to a set that already contains that value it will still have only one of that value
> (conj #{1 3 4} 2)     => output: #{1 2 3 4}