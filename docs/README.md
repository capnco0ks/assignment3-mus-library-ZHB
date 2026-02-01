Music Library API — Assignment 4

Akizhanov Assanali SE-2519

Project Overview

Console-based Java application implementing a Music Library API.
The system manages Authors and demonstrates OOP principles, SOLID architecture, Generics, Lambdas, and Reflection.

Layered architecture:
Controller → Service → Repository → Database

OOP & SOLID Design

BaseEntity: abstract class with id, name, rating

Abstract methods: getEntityType(), isValid()

Concrete method: printInfo()

Author extends BaseEntity, fully encapsulated with getters/setters and validation

SOLID principles applied:

SRP: separate classes for Service, Repository, Model

OCP/LSP: BaseEntity extensible for new entity types

DIP: Service depends on generic repository interface

Generics & Lambdas

Generic repository interface (CrudRepository<T>)

Lambda expressions used for sorting authors by rating

Reflection

ReflectionUtils inspects objects at runtime, printing:

Class name

Fields

Methods

Database Design

PostgreSQL table: authors

Fields: id, name, rating

CRUD implemented via AuthorService → AuthorRepository

Example schema:

CREATE TABLE authors (
id INT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
rating INT NOT NULL
);

Exception Handling

Custom exceptions: InvalidInputException, DuplicateResourceException, ResourceNotFoundException, DatabaseOperationException

Exceptions propagate from Repository → Service → Controller

Controller & Demonstration

Create, list, update, delete authors

Authors sorted by rating using lambdas

Reflection shows class structure at runtime

Project Structure
src/
├── controller/
├── service/
│   ├── interfaces/
├── repository/
│   ├── interfaces/
├── model/
├── exception/
├── utils/
│   ├── ReflectionUtils.java
│   ├── SortingUtils.java
├── DatabaseConnection.java
└── Main.java
resources/
└── schema.sql
README.md
.gitignore

How to Run

Create PostgreSQL database with authors table

Configure credentials in DatabaseConnection.java

Compile and run:

javac Main.java
java Main