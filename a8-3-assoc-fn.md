# ASSOC 

- assoc[iate]. When applied to a map, returns a new map of the same (**hashed/sorted**) type, that contains the mapping of key(s) to val(s). When applied to a vector, returns a new vector that contains val at index. Note - index must be <= (count vector).
> (assoc map key val) or (assoc map key val & kvs)
>
> (assoc {} :key1 "value" :key2 "another value") => output: {:key2 "another value", :key1 "value"}
>
> (assoc [1 2 3] 0 10) => output: [10 2 3]
>
> (assoc [1 2 3] 2 '(4 6)) => output: [1 2 (4 6)]
>
> (assoc [1 2 3] 3 10) => output: [1 2 3 10] when 0 < index <= n
>
> (assoc [1 2 3] 4 10) => when index > n, an error is thrown `java.lang.IndexOutOfBoundsException (NO_SOURCE_FILE:0)`
