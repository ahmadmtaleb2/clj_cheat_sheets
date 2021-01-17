# Naming values with def
- you use def to **bind** a **name** to a **value** in Clojure
- **def** as if it's defining constants

> (def p-names ["Larry Porter" "Dora the explorer" "the incredible bulk"])
>
> p-names   => output: ["Larry Porter" "Dora the explorer" "the incredible bulk"]
>
- In this case, you’re binding the name p-names to a vector containing three strings
- **bind** is equivalent to **assign** in other languages
- in other languages you can perform multiple assignments to the same variable 
- **what about clojure?**
- In Clojure, changing the value associated with a name can make it harder to understand your program’s behavior because it’s more difficult to know which value is associated with a name or why that value might have changed. Clojure has a set of tools for dealing with change **Chapter 10**
- Instead you can create a function which acceps a single argument and uses that to determine which string to return.
