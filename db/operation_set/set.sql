SELECT name FROM movie
INTERSECT
SELECT title FROM book;

SELECT title FROM book
EXCEPT
SELECT name FROM movie;

(SELECT title FROM book
EXCEPT
SELECT name FROM movie)
UNION
(SELECT name FROM movie
EXCEPT
SELECT title FROM book);