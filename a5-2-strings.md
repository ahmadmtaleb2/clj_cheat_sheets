# Strings

- Strings represent text 
- Clojure only allows **double quotes** to delineate strings. **'Lord Voldemort' is not a valid string**
- Clojure doesn’t have string interpolation. 
- **concatenation** only via the str function (str "a" "b" "c")
- **Individual characters** are represented with a leading backslash 
- special named characeters like \newline \spec \tab
- unicode characters with \uNNNN or octal \oNNN

> "string"      => string
>
> \e        => character
>
> #"[0-9]+"     => regular expression 

## functions used on strings

### .toUpperCase
- Clojure strings are Java strings. This means that you can use any of the Java string methods on Clojure strings.
> (.toUpperCase "string")

### capitalize
- Converts first character of the string to upper-case, all other characters to lower-case.
> (**clojure.string/capitalize** "mIxEd CaSe") => output: "Mixed case"