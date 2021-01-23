# REPL

- REPL is a tool for experimenting with code.
- it allows you to interact with a running program and quickly try out ideas.
- REPL development is an essential part of the Lisp experience, and you'd really be missing out if you didn't use it.
- Conceptually, the REPL is similar to Secure Shell (SSH). In the same way that you can use SSH to interact with a remote server, the Clojure REPL allows you to interact with a running Clojure process.
- This feature can be very powerful because you can even attach a REPL to a live production app and modify your program as it runs.
 


## REPL process
- with the prompt you can enter code
- it **reads** your input => an expression (a string of characters) to produce Clojure data 
- it **evaluates** it => the data returned from read to yield a result (clojure data) => Clojure always compile the expression before executing it (to JVM bytecode)
- it **prints** the result => by converting it from data back to characters
- and **loops** presenting you with a prompt again => back to the beginning 

- there is no Clojure interpreter
- this process enables a quick feedback cycle that isn't possible in most other languages.

## Start REPL
> lein repl

## Commands in REPL
- *1 => the last result 
- *2 => the result of two expressions ago 
- *3 => the result of three expressions ago 

- the **doc** function prints the documentation for any function even the one you written and ten returns nil as the result 
> (doc +)
>
> (doc my-function)

- **apropos** command to find functions that match a particular string or regular expression 
> (apropos "+")
>
> (apropos "my-function")       => output: (user/my-function)
> 
> (apropos "my-)        => output: (user/my-function) if you only have one function named as my-function, it will match all the functions that strats with "my-

- **find-doc** include the docstrings themselves in your search 
> (find-doc "trim")

- **dir** to see a full listing of the functions in a particular namespace 
> (dir clojure.repl)    => output: apropos / demunge / dir / dir-fn / doc / find-doc / pst / root-cause / set-break-handler! / source / source-fn / stack-element-str / thread-stopper   // we used it here to look up the functions available in the clojure.repl namespace 

- **source** => we can see not only the documentation but the underlying source for any function accessible by the runtime
> (source dir)
