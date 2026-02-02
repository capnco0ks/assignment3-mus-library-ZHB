package service;

import exception.DuplicateResourceException;
import exception.InvalidInputException;
import exception.ResourceNotFoundException;
import model.Author;
import repository.interfaces.CrudRepository;
import repository.AuthorRepository;
import service.interfaces.AuthorServiceInterface;

import java.util.List;
import java.util.Comparator;

public class AuthorService implements AuthorServiceInterface {

    private final CrudRepository<Author> authorRepository;

    public AuthorService(CrudRepository<Author> repository) {
        this.authorRepository = repository;
    }

    @Override
    public void create(Author author) {
        if (author == null) throw new InvalidInputException("Author cannot be null");
        author.validate();
        try {
            authorRepository.getById(author.getId());
            throw new DuplicateResourceException("Author with this ID already exists");
        } catch (ResourceNotFoundException e) {
            authorRepository.create(author);
        }
    }

    @Override
    public List<Author> getAll() {
        List<Author> authors = authorRepository.getAll();
        authors.sort(Comparator.comparingInt(Author::getRating).reversed());
        return authors;
    }

    @Override
    public Author getById(int id) {
        if (id <= 0) throw new InvalidInputException("ID must be positive");
        try {
            return authorRepository.getById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Author with id " + id + " not found");
        }
    }

    @Override
    public void update(int id, String newName, int newRating) {
        if (newName == null || newName.isBlank()) throw new InvalidInputException("Name cannot be empty");
        if (newRating < 0 || newRating > 10) throw new InvalidInputException("Rating must be 0-10");
        Author updated = new Author(id, newName, newRating);
        try {
            authorRepository.update(id, updated);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Author with id " + id + " not found");
        }
    }

    @Override
    public void delete(int id) {
        if (id <= 0) throw new InvalidInputException("ID must be positive");
        try {
            authorRepository.delete(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Author with id " + id + " not found");
        }
    }
}
