package service;

import model.Author;
import repository.AuthorRepository;

import java.util.List;

public class AuthorService {

    private final AuthorRepository authorRepository = new AuthorRepository();

    public void create(Author author){
        if (author==null){
            throw new IllegalArgumentException("Author cannot be null");
        }
        if (author.getName() == null || author.getName().isBlank()){
            throw new IllegalArgumentException("Author cannot be empty");
        }
        try {
            authorRepository.getById(author.getId());
            throw new IllegalArgumentException("author with this ID already exists");
        }
        catch (RuntimeException e){

        }
        authorRepository.create(author);
    }

    public List<Author> getAll(){
        return authorRepository.getAll();
    }

    public Author getById(int id){
        if (id<0){
            throw new IllegalArgumentException("id must be positive");
        }
        return authorRepository.getById(id);
    }

    public void update (int id, String newName){
        if (newName == null || newName.isBlank()){
            throw new IllegalArgumentException("Author cannot be empty");
        }
        Author updatedAuthor = new Author(id,newName);
        authorRepository.update(id,updatedAuthor);
    }

    public void delete (int id){
        if (id<=0){
            throw new IllegalArgumentException("author ID must be positive");
        }
        authorRepository.delete(id);
    }
}
