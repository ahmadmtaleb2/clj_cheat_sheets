# Lists

- Lists are similar to vectors in that they’re linear collections of values
- List values can have any type

## Create a list

- list literal:
> '(1 2 3 4) ; => (1 2 3 4)
- list function:
> (list 1 "two" {3 4}) ; => (1 "two" {3 4})

## look up for values

- you **can’t** retrieve list elements with **get**
- to retrieve an element from a list, you can use the nth function:
> (nth '(:a :b :c) 0) ; => :a


## functions used on lists

### Conj
- **conj** function is used to add additional elements to the list.
- Elements are added to the beginning of a list
> (conj '(1 2 3) 4) ; => (4 1 2 3)
