# LET
- let binds names to values (assign names to values)
- you can think of it as a short of **let it be**
- the value of a let form is the last form in its body that is evaluated
- let forms have two main uses
    1. provide clarity by allowing you to name things
    2. they allow you to evaluate an expression only once and reuse the result.
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
