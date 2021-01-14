# Strings

- Strings represent text => "string"
- Clojure only allows **double quotes** to delineate strings. **'Lord Voldemort' is not a valid string**
- Clojure doesn’t have string interpolation. 
- **concatenation** only via the str function (str "a" "b" "c")

## functions used on strings

### .toUpperCase
- Clojure strings are Java strings. This means that you can use any of the Java string methods on Clojure strings.
> (.toUpperCase "string")

### capitalize
- Converts first character of the string to upper-case, all other characters to lower-case.
> (**clojure.string/capitalize** "mIxEd CaSe") => output: "Mixed case"