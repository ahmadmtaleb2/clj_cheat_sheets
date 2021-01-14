# Data Structures
- All of Clojure’s data structures are **immutable**, meaning you can’t change them in place


## Notes on List and Vectors
- *it’s good to know that using nth to retrieve an element from a list is slower than using get to retrieve an element from a vector. This is because Clojure has to traverse all n elements of a list to get to the nth, whereas it only takes a few hops at most to access a vector element by its index.*
- **When should you use a list and when should you use a vector?** 
- A good rule of thumb is that if you need to easily add items to the beginning of a sequence or if you’re writing a macro, you should use a list. Otherwise, you should use a vector.

