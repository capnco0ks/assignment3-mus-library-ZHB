package repository;

import model.Author;
import utils.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {
    public void create(Author author){
        String sql = "INSERT INTO authors(id, name) VALUES (?, ?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,author.getId());
            ps.setString(2, author.getName());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to insert author :( ",e);
        }
    }

    public List<Author> getAll(){
        List<Author> authors = new ArrayList<>();
        String sql = "SELECT id, name FROM authors";
        try (Connection conn = DataBaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

                while(rs.next()){
                    authors.add(new Author(rs.getInt("id"),rs.getString("name")));
                }
            }
        catch (SQLException e){
                throw new RuntimeException("Failed to fetch authors");
        }
        return authors;
    }
}
