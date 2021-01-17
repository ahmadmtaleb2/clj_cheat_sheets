# if
- general structure for **if** expression:

>(if boolean-form       then-form       optional-else-form)

- if you omit the **else** branch and the boolean expression is false, Clojure returns **nil** 
- **if** uses operand position to associate operands with the **then** and **else** branches: the **first operand** is the **then** branch, and **the second operand** is the (optional) **else** branch
- each branch can have **only one form**.

# do
- to get around the apparent limitation of each branch having only one form, we can use the **do** operator
- The **do** operator lets you **wrap up multiple** forms in parentheses and run each of them.

>(if true       (do (println "Success!") "By Zeus's hammer!")       (do (println "Failure!") "By Aquaman's trident!"))

# When
- The **when** operator is like a combination of if and do , but with no else branch.
- Use **when** if you want to do multiple things when some condition is true, and you always want to return nil when the condition is false.

> (when true    (println "Success!")    "abra cadabra")

# nil, true, false, Truthiness, Equality, and Boolean Expressions

## nil
- nil is used to indicate no value in Clojure.
- you can check if a value is nil with the appropriately named **nil?** function

>(nil? 1)   => output: false
>
>(nil? nil)     => output: true

## Truthy and Falsey
- **nil** and **false** are used to represent logical falsiness
- all other values are logically truthy
- truthy and falsey refer to how a value is treated in a boolean expression 
- When using Clojure's built-in data structures you don't need for special operator when testing equality
- In Clojure, there is no special string equality operator made just for strings

## or
- **or** returns either the **first truthy** value **or** the **last value**.
> (or false nil :blah)      => output: :blah

## and
- **and** returns **the first falsey** value **or**, if no values are falsey, **the last truthy** value.
> (and :free-wifi :hot-coffee)      => output: :hot-cofee