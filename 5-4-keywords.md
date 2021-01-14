# Keywords

- They’re primarily used as keys in maps
- Keywords can be used as **functions** that look up the corresponding value in a data structure
> (:a {:a 1 :b 2 :c 3}) ;=> 1
- you can provide a default value like get
> (:d {:a 1 :b 2 :c 3} "No gnome knows homes like Noah knows") ; => "No gnome knows homes like Noah knows"
- Using a keyword as a function is pleasantly succinct, and Real Clojurists do it all the time.