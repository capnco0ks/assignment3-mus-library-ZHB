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

    public Author getById(int id){
        String sql = "SELECT id,name FROM authors WHERE id = ?";

        try(Connection conn = DataBaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return new Author(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }
            throw new RuntimeException("Author not found");
        } catch (Exception e) {
            throw new RuntimeException("failed to connect",e);
        }
    }

    public void update (int id, Author author){
        String sql = "UPDATE authors SET name = ? WHERE id = ?";

        try(Connection conn = DataBaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,author.getName());
            ps.setInt(2,id);

            int updated = ps.executeUpdate();

            if (updated == 0){
                throw new RuntimeException("Author not found");
            }
        }
        catch (SQLException e ){
            throw new RuntimeException("failed to update", e);
        }

    }
    public void delete(int id){
        String sql = "DELETE FROM authors WHERE id = ?";

        try (Connection conn = DataBaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);

            int deleted = ps.executeUpdate();
            if(deleted == 0){
                throw new RuntimeException("Author not found");
            }
        }
        catch(SQLException e){
            throw new RuntimeException("failed to delete", e);
        }

    }
}
