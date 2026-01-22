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
        authorRepository.create(author);
    }

    public List<Author> getAll(){
        return authorRepository.getAll();
    }

    public Author getById(int id){
        return authorRepository.getById(id);
    }

    public void update (int id, Author author){
        authorRepository.update(id,author);
    }

    public void delete (int id){
        authorRepository.delete(id);
    }


}
