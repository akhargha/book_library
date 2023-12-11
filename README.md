# Personal Library Service - CPSC 310 (Software Design)

Submitted by: **Anupam Khargharia & Hamim Mahdie**

**Personal Library Service** is a library service with CRUD methods and a frontend built using HTML, CSS, JavaScript, and Bulma.

## Required Features

The following **required** functionality is completed:

* [X] Book should be a Java POJO that contains strings for title, author, and ISBN, and a LocalDate for the publication date. It should also have an `Long` id so that each book can be saved in a database.
* [X] BookController should be a rest controller with methods to get all the books, add a new book, and delete an existing book by id. You may add additional methods if you want or if they're convenient.
* [X] Use an H2 database to save the data.
* [X] Use a JpaRepository for the BookRepository implementation
* [X] Add validation constraints on the fields in `Book` as appropriate.


The following **optional** features are implemented:

* [X] The book controller must have a test case. Be as complete on the tests as possible.
* [X] Frontend for the application using HTML, CSS, JavaScript, and Bulma.
* [X] Additional functions like search and delete by ISBN.

## How to setup

Here's a walkthrough to run the program:

1. ![Screenshot 2023-12-11 at 10 56 53 AM](https://github.com/akhargha/book_library/assets/118499953/06de49b2-9bef-4545-ba67-cecd0578f35c)
Click on the play button on the top right corner (next to "Current File"). This will run the BookLibraryApplication.java under src.main.java.edu.trincoll_book_library
Now our application is up and running.

2. To run the tests, navigate to the tests and click on the same icon. The tests included in this file are BookControllerTest and BookRepositoryTest under src.test.java.edu.trincoll_book_library

3. To run the frontend, go to index.html and hit the same green play button. This will open up your browser with the website.

Here is a preview of what it looks like-
![Screenshot 2023-12-11 at 11 01 03 AM](https://github.com/akhargha/book_library/assets/118499953/09780d8c-bd3b-4355-be7d-fb0de8449908)


Future enhancements **optional**:

* [] Advanced search functionality: Ability to search by various attributes including Name, Author, Date, and more.
* [] Dynamic filtering options: mplementation of sorting and filtering constraints. Users will be able to sort results and apply filters such as book name, publication date range, etc., making it easier to find specific titles.


## Notes

Overall, this was a great project to work on and I loved learning how to could connect the backend with the frontend. The project provided a practical, hands-on way to understand the workings of applications. I wish we could have done more (and bigger) projects like this in the class as this project clarified a lot of concepts for me and built an understanding of how applications work and how to write an actual application. 
