## Numeric types 
- **integers** are read as fixed precision **64-bit** integers when they are in range and arbitrary precision otherwise
> 93        => integer

- Clojure supports the java syntax for octal => *prefix* 0
- hexadecimal => *prefix* 0x
- arbitrary radix integers => *prefix* r

- **ratio** are provided as their own type combining a numerator and denominator 
> 1/2       => ratio
- **Floting point** values are read as double precision **64-bit** floats, or arbitrary precision with an M suffix
> 1.2       => float

- Exponential notation is supported 

- **##Inf** => positive infinity 
- **##-Inf** => negative infinity 
- **##NaN** => not a number value