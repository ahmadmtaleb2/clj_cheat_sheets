# Notes
## Ring
- Ring is an interface spec
- this spec defines Request, and response map contents and how a function, called handler, should treat them 
- a web application in Ring is simply a Clojure function, thus it can leverage all the standard Clojure tools for processing maps and for handling functions. (this also makes it trivial to test in repl)
## handler
- A handler is just a function that takes a map and returns a map 
- what the keys are, and what their corresponding values are is details in the spec. (Ring spec?)
- Do look at the spec, and reference it whenever a new request or response key is introduced 
- the handler ignores the details of the request (such as the uri and the http method) and returns a "hello, World!" resource.

> (defn hello-handler [req]
    {:body "Hello, World!"
     : headers {}
     : status 200})
>
> (hello-handler {:uri "/hello"}) 
    {:body "Hello, World!"
     : headers {}
     : status 200}

## middleware
- middleware. Note that middleware are called in the reverse order to the wrapping, e.g. the inner most middleware handles the incoming request last and the outgoing response first, while the outer most middleware handles the incoming request first and the outgoing request last (what does this means?)

## adapter
- The adapter is responsible for not only connecting a handler to a server, but for abstracting away the details of that particular server. As a result each adapter can vary quite a bit in the details of how it is implemented and used.

## 

- The #' known as var quote; this allows you rebind greeting‑handler in your REPL and the server will immediately reflect your changes. You can also start and stop your server from the repl with (.start server) and (.stop server).


## summary
- **Handler** => A function that takes a request map and may return a response map.
- **Middleware** => A Middleware takes a Handler and wraps it with a new handler that interposes itself between the caller and the handler and operates on either or both of request and response.
- **Adapter** => Connects a top level Ring handler to an HTTP Server.


## Clojars 
- it is a dead easy community repository for open source Clojure libraries.

(require '[clojure.spec.alpha :as s])
(defn person-name
[person]
{ :pre [(s/valid? ::person person)]
:post [(s/valid? string? %)]
}
(str (::first-name person) " " (::last-name person)))