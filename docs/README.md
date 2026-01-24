# Music Library API — Assignment 3 
Akizhanov Assanali SE-2519

Project Overview
This project is a console-based Java application that implements a Music Library API.
The system allows managing media content such as Songs and Podcasts, as well as Authors,
using Object-Oriented Programming principles, JDBC, and a PostgreSQL database.

The application follows a multi-layer architecture:
Controller → Service → Repository → Database.

OOP Design
The core abstract class is Media.
It contains common fields such as id, name, duration, and author.
The class defines an abstract play() method and a concrete displayInfo() method.

Two subclasses extend Media:
Song and Podcast.
Polymorphism is demonstrated by calling overridden methods through a Media reference.

Two interfaces are used:
Playable, which defines the play() method.
Validatable, which defines the isValid() method.

Composition is implemented by including an Author object inside Media.

Database Design
The project uses PostgreSQL as a relational database.
Two main tables are created:
authors and media.

The media table contains a foreign key that references authors(id).

Example schema:
CREATE TABLE authors (
id INT PRIMARY KEY,
name VARCHAR(100) NOT NULL
);

JDBC and CRUD
JDBC is implemented using DriverManager, Connection, and PreparedStatement.
Statement is not used.

CRUD operations are implemented for the Author entity:
create
getAll
getById
update
delete

Validation and business rules are handled in the Service layer.

Exception Handling
The project uses a custom exception hierarchy:
InvalidInputException
DuplicateResourceException
ResourceNotFoundException
DatabaseOperationException

Exceptions are propagated from Repository to Service and then to Main.

Controller and Demonstration
The Main class demonstrates:
creating authors
reading all authors
updating author data
deleting authors
handling errors such as deleting a non-existing author
polymorphism using Media references

How to Run
1. Create a PostgreSQL database
2. Configure database credentials in DataBaseConnection
3. Compile and run the project using:
   java Main

Project Structure
src/
controller/
service/
repository/
model/
exception/
utils/
Main.java

Reflection
During this project I learned how to apply OOP principles,
how to work with JDBC and relational databases,
and how to design a clean multi-layer architecture.

Author
Assignment completed as part of Advanced OOP and JDBC coursework.
