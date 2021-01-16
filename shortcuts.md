# Shortcuts in Intellij IDEA

- herein after some useful shortcuts 

# Search 
- Double shift => search

# auto completion and suggestions
- ctrl + space => to show the completion suggestions
- ctrl + space *2 => suggestions
    - tab pressed after the going in the suggestion list will replace the word at the caret rather than simply inserts it.
    - enter will just insert it
-  ctrl + shift + space => list of suggestions 
- . => transform an already typed expression into another one based on the prefix you add 
- ctrl + shift + enter => to complete the statement => if you type **for** it will create the parentheses and the curly braces indended for you 
- alt + enter => to get suggestions for solving the error 



# select and actions 
- ctrl + w => to select a word 
- ctrl + w *n => to select a string or a statement or a block of code 

- ctrl + / => comment
- ctrl + d => duplicate a line 

- ctrl + shift + arrow (up & down) => **move a block of code up & down**

- ctrl + - => collapse a code block
- ctrl + = => expand a code block
- ctrl + shift + - => collapse all code in the file 
- ctrl + shift + = => expand all code in the file 

- alt + j => select the symbol at the caret
- alt + j *n => select the next occurence 

- alt + shift + j => deselect the last occurence 
- ctrl + shift + alt + j => select all the occurences of the symbol at caret in the file 

- shift + F6 => to rename a field => enter => all the field will be changed => intellijIDEA will detect the functions names affected also to change their naming 

- ctrl + alt + v => extract a local variable and choose the name to replace => could be applied on all the occurences

- ctrl + alt + M => to extract the selected code block into a method => refactor => replace

- ctrl + alt + l => reformat the selected code fragment
- ctrl + alt + l => reformat the whole file when no lines are selected 

- ctrl + p => see the method's signature

- ctrl + q => to see documentation for symbol at the caret
- ctrl + shift + i => to see the definition of the symbol at the caret 

- F2 => to go to the next highlighted error in the file 
- ctrl + F1 => to see a short description => again => to expand it 
- ctrl + shift + F7 => to highlight all usages of the symbol at the caret within the file 

# file structure 
- ctrl + F12 => to open the file structure 
- alt + 7 => show you the file structure as a tool window 
- ctrl + e => show recently opened files
- alt + 3 => to open the find view again 
- shift + escape => to hide the view


- ctrl + b => to jump to the declaration of a method 
- ctrl + b => to see all of the method usages, then select one of them 
- alt + shift + 7 => to see a more detailed view of usages => it is invokable on either a declaration or a usage


- ctrl + alt + b => to look for implementation of some interface
- ctrl + u => to navigate to a super method => or the icon with an arrow up in the gutter
- ctrl + shift + h => to explore the whole hierarchy 
- ctrl + h => to view the class hierarchy 

- ctrl + f => to start a full-text search through the current file 
- shift + F3 => to jump to the previous occurence => go backwards
- F3 or enter => go forwards

# run and debug
- ctrl + shift + F10 => run 
- shift + escape => hide the tool windiw 
- Intellij IDEA creates a temporary run configuration for each run. temporary configurations are automatically deleted if the default limit of five is reached => you can convert the temporary configuration into a permanent one => drop-down menu beside the run button => save 'sample' configuration 
- to change a configuration or create another one manually => in the same drop-down menu => Eit configurations or ctrl + shift + A -> edit configurations action
- this is a place for managing run/debug configurations. => here you can set program parameters, JVM arguments, environment variables, and so on 
- sometimes you want to save a configuration to its own file => such configurations will be easy to share (usually by using a version control system)

- ctrl + F8 => to set a breakpoint => or click on the editor gutter

