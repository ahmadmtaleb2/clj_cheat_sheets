# seq or Sequences

- Clojurists usually use **seq** instead of sequence, using terms like seq functions and the seq library to refer to functions that perform sequential operations. Whether you use sequence or seq, you’re indicating that the data structure in question will be treated as a sequence and that what it actually is in its truest heart of hearts doesn’t matter in this context.
- If the core sequence functions first , rest , and cons work on a data structure, you can say the data structure implements the sequence abstraction.
- Lists, vectors, sets, and maps all implement the sequence abstraction

- when it comes to using seq functions on a data structure, all Clojure asks is **“can I first , rest , and cons it?”** If the answer is yes, you can use the seq library with that data structure.
- when it comes to sequences, Clojure creates indirection by doing a kind of leightweight **type conversion**, producing a data structure that workds with an abstraction's functions
- whenever Clojure expects a sequence (calling map, first, rest, cons) it calls the **seq** function on the data structure in question to obtain a data structure that allows for first, rest, and cons 

> (seq '(1 2 3)) => output: (1 2 3)
>
> (seq [1 2 3]) => output: (1 2 3)
>
> (seq #{1 2 3}) => output: (1 2 3)
>
> (seq {:a 1 :b 2 :c 3}) => output: ([:a 1] [:b 2] [:c 3])

- **seq** always returns a value that looks and behaves like a list -> you’d call this value a sequence or seq

- seq of a map consists of two-element key-value vectors => That’s why map treats maps like lists of vectors
> converting the seq back into a map 
>
> (into {} (seq {:a 1 :b 2 :c 3}) => output: {:a 1, :c 3, :b 2}

- Clojure’s sequence functions use seq on their arguments.
- The sequence functions are defined in terms of the sequence abstraction, using first , rest , and cons . As long as a data structure implements the sequence abstraction, it can use the extensive seq library, which includes such superstar functions as reduce, filter, distinct, group-by, and dozens more.


# Lazy Seqs
- Many functions, including map and filter , return a lazy seq. 
- A lazy seq is a seq whose members aren’t computed until you try to access them. 
- Computing a seq’s members is called **realizing** the seq
- Deferring the computation until the moment it’s needed makes your programs more efficient, and it has the surprising benefit of allowing you to construct **infinite sequences**.
- When you use map , the lazy seq it returns doesn’t include any realized elements yet, but it does have the recipe for generating its elements. 
- Every time you try to access an unrealized element, the lazy seq will use its recipe to generate the requested element.
- Clojure chunks its lazy sequences, which just means that whenever Clojure has to realize an element, it pre-emptively realizes some of the next elements as well.
- Clojure comes with a few functions to create infinite sequences like repeat

- A lazy seq’s recipe doesn’t have to specify an endpoint. 
- Functions like first and take , which realize the lazy seq, have no way of knowing what will come next in a seq, and if the seq keeps providing elements, well, they’ll just keep taking them.