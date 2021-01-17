# LET

- you can think of it as a short of **let it be**
- let binds symbols to values (assign symbols to values) in a lexical scope
-  A lexical scope creates a new context for names, nested inside the surrounding context. 
- Names defined in a let take precedence over the names in the outer context.
- the value of a let form is the last form in its body that is evaluated
- let forms have two main uses
    1. provide clarity by allowing you to name things
    2. they allow you to evaluate an expression only once and reuse the result.
- Each let can define 0 or more bindings and can have 0 or more expressions in the body.
- 

>(def dalmatian-list
>
>    ["Pongo" "Perdita" "Puppy 1" "Puppy 2"])
>
>    (let [dalmatians (take 2 dalmatian-list)]
>    dalmatians)
>
> output: ("Pongo" "Perdita")
>
- you can use rest parameters in let, just like you can in functions

> (let [[pongo & dalmatians] dalmatian-list]
>
> // In this case, [pongo & dalmatians] destruc- tured dalmatian-list , binding the string "Pongo" to the name pongo and the list of the rest of the dalmatians to dalmatians .
>
>    [pongo dalmatians])
> output: ["pongo" ("Perdita" "Puppy 1" "Puppy 2")]
