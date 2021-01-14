# Sets
- Sets are collections of unique values
- multiple instances of a value become one unique value in the set
- Clojure has two kinds of sets: 
    1. hash sets
    2. sorted sets
## Create a set
1.  hash set literal:
> #{"kurt vonnegut" 20 :icicle}

2. hash-set:
> (hash-set 1 1 2 2) ; => #{1 2}

3. from existing vectors and lists by using the set function:
> (set [3 3 3 4 4]) ; => #{3 4}

4. adding 2 sets
> (**clojure.set/union** #{:a :b :c} #{:b :c :d}) => output: #{:a :b :c :d}


## functions used on sets

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
