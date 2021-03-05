# SQL

- database is a computer program which stores various data. 
- There are quite a few database vendors, e.g., Oracle, MySQL, PostgreSQL, SQL Server, and many others.
-  There are various types of databases. Relational databases are one of those types and they're a very frequent choice in the contemporary IT world.
- Every relational database stores information in tables. 
- You can have many tables in one database and each of your tables will hold data which refers to similar objects. 
- Each table has a name so you can find out what kind of information is stored there.
- **For example**, the database of your university would include a table named student with all data regarding students, another table subject with information on the subjects at your university, etc.
- Tables in databases have columns and rows.
    - Columns in every table have their names and they identify the kind of information is stored in them.
    - Each row stores information about one object. 
- Structured Query Language or SQL for short is how we get in touch with our database => you'll query the database for data
- All relational databases understand SQL, but each of them has a slightly different dialect, so to speak.
- queries are questions that we ask to find out some information about the data stored in the database.
- Databases can do amazing things – they don't only return the data you ask for, they can actually do advanced calculations on the tables.

# Gett all data 
- you can see all the data in a table with this query
> SELECT * FROM table-name;
- **SELECT** tells your database that you want to select data 
- **FROM table_name** tells the database to select data from the table with table-name specified
- * tells the database that you want to see all columns in this table 
- it is a good practice to always end your SQL command with a semicolon (**;**) => it tells the databse that you're done with your command 

# select one or many column 
- if you want to select one column you can use the following query 
> SELECT column_name1, column_name2  FROM table_name;

# conditions 
## WHERE
- we can retrieve data based on a pre-defined condition by using **WHERE**
> SELECT * FROM table_name WHERE id = value;
- value could be numbers or text
- the text is used in singe quotes so if value is a text **'value'** is the format
- The case of the letters matters 'Smith' is different than 'SMITH'

## conditional operators
- in writing our condition in our query we can apply several operators
    - < less than 
    - > greater than 
    - <= less than or equal 
    - >= greater than or equal 
    - != or <> inequality 
## logical operators
- it can be used to combine conditions 
    - **OR** => a row is displayed when the first condition or the second condition is true. Note that if both conditions are true, the row is also displayed.
    > SELECT name FROM user WHERE age > 50 OR height < 185

    - **AND** =>  both conditions must be fulfilled to retrieve a particular row.
    > SELECT name FROM user WHERE age <= 70 AND age >= 13;

    - **BETWEEN** => means that we look for rows with the  column_name set to be anything between value1 and value2, including these values. => check how BETWEEN works => to detect if value1 and value2 are included in the result or not 
    > SELECT model FROM car WHERE production_year BETWEEN 1995 AND 2005;

    - **NOT** => whatever is stated after NOT will be negated
    > SELECT name FROM user WHERE age NOT BETWEEN 20 AND 30

    - **()** => we can join more conditions by using parentheses according to our needs
    > SELECT name FROM user WHERE (age > 70 OR age < 13) AND (height >= 180);

    - **LIKE '%A%'** => with text values we can always use the **LIKE** operator instead of the equality sign => the percentage **%** sign applied matches any number of unkown characters (zero or more) => the percentage sign (%) can be put anywhere between the single quotes and as many times as it's necessary 
    > SELECT * FROM user WHERE name LIKE '%A%';

    - **LIKE '_a'** => the underscore sign _ matches exactly one character => the following will match Catherine and Katherine
    > SELECT * FROM user WHERE name LIKE '_atherine';

    - **NULL** => fields with unknown or missing values => to check whether a column has a value, we can use a special instruction **IS NOT NULL**
    > SELECT * FROM user WHERE name IS NOT NULL;

    - you can't use the equal sign to check whether something is NULL => you can check if it **IS NULL**
    > SELECT * FROM user WHERE name IS NULL;

    - NULL is not equal to zero => NULL = NULL is **never true** in SQL => if you set a condition on a particular column, the row with NULL value will be **excluded** from the result

    - we can apply and use **simple mathematics** is SQL
    > SELECT * FROM user WHERE (salary * 12) > 10000;

# JOIN
- used for joining to table
- relation 
- the **ON** clause is to set the condition
- we put the table name in front of the column name and we separate them with a dot (.). In this way, SQL knows that the column model belongs to which table. => *If the name of the column is unique, though, you may omit the table name.*
> SELECT * FROM person JOIN car ON person.id = car.owner_id; 
- **as** => alias for column name means it's temporary and doesn't change the actual column name in the database. It only influences the way the column is shown in the result of the specific query. This technique is often used when there are a few columns with the same name coming from different tables. Normally, when SQL displays columns in the result, there is no information about the table that a specific column is part of.
- we can apply conditions in Join by using **WHERE**
> SELECT * FROM person JOIN car ON person.id = car.owner_id WHERE person.age < 25; 

## INNER JOIN
- INNER JOIN is the most common one 
- always applied by default when you write the keyword JOIN in SQL satatemet
- **INNER JOIN** only shows those rows from the two tables where there is a **match** between the columns. 
- columns which have NULL values in the columns that we are joining on, they will not appear

## LEFT JOIN
- LEFT JOIN returns all rows from the **left** table (the **first** table in the query) plus all matching rows from the **right** table (the **second** table in the query)
> SELECT * FROM car LEFT JOIN person ON car.owner_id = person.id;

## RIGHT JOIN
- RIGHT JOIN returns all rows from the **right** table (the **second** table in the query) plus all matching rows from the **left** table (the **first** table in the query)
> SELECT * FROM car RIGHT JOIN person on car.owner_id = person.id;

**Notice that the order of the tables in LEFT and RIGHT JOIN matters. In other words, car RIGHT JOIN person is the same as person LEFT JOIN car. Don't confuse the order!**

## FULL JOIN
- FULL JOIN returns all rows from both tables and combines the rows when there is a match. In other words, FULL JOIN is a union of LEFT JOIN and RIGHT JOIN.
> SELECT * FROM car FULL JOIN person ON car.owner_id = person.id;
- **some databases don't support FULL JOIN**

## OUTER JOINS
- LEFT JOINS, RIGH JOIN, FULL JOIN are all **shortcuts** for LEFT OUTER JOIN, RIGHT OUTER JOIN, and FULL OUTER JOIN.

## NATURAL JOIN
- NATURAL JOIN doesn't require the **ON** clause with the joining condition 
- NATURAL JOIN doesn't require column names because it always joins the two tables on the columns with the same name.
- 
> SELECT * FROM person NATURAL JOIN car;

## IMPORTANT1
- we can join the table to itself 
- if we have a person table we can join it to person table in order to display some needed data
- the right way is to use aliases
- thanks to the aliases 
> WE CANNOT QUERY THE FOLLOWING: person JOIN PERSON
>
>THE RIGHT WAY:  SELECT * FROM person as p1 JOIN person as p2 ON p1.id = p2.mother_id;  //=> the database engine will use the same table person twice 

## IMPORTANT2 
- **You can use more than one join in your SQL instruction.**


# ORDER BY
- by defaultm the result of an SQL query is not sorted at all 
- The sequence in which rows appear is arbitrary and every database can behave differently
- You can even perform the same SQL instruction a few times and get a different order each time – unless you ask the database to sort the rows
- by using **ORDER BY** you are specifying a column on which the data will be sorted.
> SELECT * FROM orders ORDER BT customer_id;

- The **WHERE** clause and **ORDER BY** work well together.
> SELECT * FROM orders WHERE customer_id = 100 ORDER BY total_sum;

- **ASC** => keyword used with ORDER BY to order the result by ascending order => from lowest to highest => this **ascending** order of results is performed in SQL by default
- **DESC** => keyword used with ORDER BY to order the result by descending order => from highest to lowest => **descending**
> SELECT * FROM orders ORDER BY total_sum ASC;
>
> SELECT * FROM orders ORDER BY total_sum DESC;

- you can sort your results by more than one column and each of them can be sorted in a different order (which means by different ASC and DESC)

> SELECT * FROM order ORDER BY customer_id ASC, total_sum DESC;         // => the results will first be sorted by customer_id in the ascending order (lowest values first) and then, for each customer_id, the orders will be sorted by the total_sum in the descending order (greatest values first).

# SELECT DISTINCT
- when selecting DISTINCT the database will remove duplicates and only show distinct values
> SELECT DISTINCT customer_id FROM orders;
- DISTINCT could operate on group of columns => the distinct result returned is distinct per row (this to be checked if true)

# Aggregation 
- A function in SQL always has a name followed by parentheses. In parentheses, you can put information which the function needs to work.
## Count
- COUNT() calculates the number of rows specified in the parentheses.
- COUNT(*) means count all rows 
- as a result, we'll get the number of all rows in the table and not their content 
> SELECT COUNT(*) FROM orders;

- COUNT(*) => counts all rows in the table
- COUNT (customer_id) => count all rows in the specified value which is in this case customer_id column => **in this case, if there is a Null in the column customer_id, the row won't be counted**
- DISTINCT could be used in COUNT() => in this case, we count all rows which have a distinctive value in the column specified.
> SELECT COUNT(DISTINCT customer_id) FROM orders;  //=> this instruction tells us how many different customers have placed an order so far. if a customer places 5 orders, the customer will only be counted **once**

## MIN 
- MIN() function returns the smallest value of the column specified 
> SELECT MIN(total_sum) FROM orders;

## MAX 
- MAX() function returns the biggest value of the specified column 
> SELECT MAX(total_sum) FROM orders;

## AVG
- AVG() function returns the average value of the specified column 
> SELECT AVG(total_sum) from orders;

## SUM 
- SUM() function returns the total sum of the specified column
> SELECT SUM(total_sum) FROM orders;

## GROUP BY
- GROUP BY will grup together all rows having the same value in the specified column 
> SELECT customer_id, COUNT(*) FROM orders GROUP BY customer_id; //=> all orders made by the same customer will be grouped together in one row. The function COUNT(*) will then count all rows for the specific clients. As a result, we'll get a table where each customer_id will be shown together with the number of orders placed by that customer.

- GROUP BY could be used for more than one column

- in such queries each column in the SELECT part must either be used later for grouping or it must be used with one of the functions.

> SELECT cutomer_id, order_date, SUM(total_sum) FROM orders GROUP BY cutomer_id, order_date;

## HAVING
- HAVING is used to set the condition on GROUP BY to filter the results
> SELECT customer_id, order_date, SUM(total_sum) FROM orders GROUP BY customer_id, order_date HAVING SUM(total_sum) >2000;  //=> in this case, we only want to show those customers who, on individuals days, ordered goods with a total daily value of more than 2000

### IMPORTANT
- In SQL, the specific fragments must always be put in the right order. 
- You can't put WHERE before FROM
- HAVING must always follow GROUP BY 

- **GROUP can be sorted like rows**
> SELECT customer_id, order_date, SUM(total_sum) FROM orders GROUP BY customer_id, order_date ORDER BY SUM(total_sum) DESC;
