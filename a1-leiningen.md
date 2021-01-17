# Leiningen
- When you install Leiningen, it automatically downloads the Clojure compiler, **clojure.jar**
- Leiningen is the de facto standard build tool for Clojure


## leiningen intended use
1. Creating a new Clojure project
2. Running the Clojure project
3. Building the Clojure project -> to create an executable JAR file -> shareable
4. Using the REPL

## Create a new clojure project 
> lein new app app-name

- The project skeleton is just a convention used by Leiningen.
- Leiningen will be used to build and run Clojure apps, and Leiningen expects your app to have this structure. 
- The first file of note is **project.clj**, which is a configuration file for Leiningen. It helps Leiningen answer such questions as **“What dependencies does this project have?”** and **“When this Clojure program runs, what function should run first?”** 
- In general, you’ll save your source code in src/<project_name>. In this case, the file src/clojure_noob/core.clj is where you’ll be writing your Clojure code for a while. 
- The **test** directory obviously contains tests, and 
- **resources** is where you store assets like images.

## Running the Clojure project
> lein run

## Building the Clojure project
> lein uberjar

- to share your work with people who don't have Leiningen installed, you can create a stand-alone file that anyone with java installed can execute.
- building the project with the previous mentioned command will creates the file **file target/uberjar/clojure-noob-0.1.0-SNAPSHOT-standalone.jar.** and you can make Java execute it by running this:
> java -jar file target/uberjar/clojure-noob-0.1.0-SNAPSHOT-standalone.jar.
>
- The file **target/uberjar/clojure-noob-0.1.0-SNAPSHOT -standalone.jar** is what you can distribute and run on almost any platform.