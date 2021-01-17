# REPL

- REPL is a tool for experimenting with code.
- it allows you to interact with a running program and quickly try out ideas.
- REPL development is an essential part of the Lisp experience, and you'd really be missing out if you didn't use it.
- Conceptually, the REPL is similar to Secure Shell (SSH). In the same way that you can use SSH to interact with a remote server, the Clojure REPL allows you to interact with a running Clojure process.
- This feature can be very powerful because you can even attach a REPL to a live production app and modify your program as it runs.
 


## REPL process
- with the prompt you can enter code
- it **reads** your input
- it **evaluates** it
- it **prints** the result 
- and **loops** presenting you with a prompt again.

- this process enables a quick feedback cycle that isn't possible in most other languages.

## Start REPL
> lein repl

