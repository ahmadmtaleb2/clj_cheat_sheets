;; 4clojure solutions

;; Nth element: Write a function which returns the Nth element from a sequence.
;; without using nth
(fn [list index] (last(take (inc index) list)))

;;Write a function which returns the total number of elements in a sequence.
;; without using count
(fn el-number [list] (reduce (fn [x y] (+ x 1)) 0 list))

;;Write a function which reverses a sequence.
;; without reverse or rseq
(fn [list] (reduce conj '() list))

;;Write a function which returns the sum of a sequence of numbers.
(fn [list] (reduce + list))

;;Write a function which returns only the odd numbers from a sequence.
