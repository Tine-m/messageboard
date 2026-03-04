package app.persistence;

import app.entities.Post;
import app.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostMapper {

    public static List<Post> findAll(ConnectionPool connectionPool) throws DatabaseException {
        String sql = "SELECT id, title, content, image FROM post";
        List<Post> posts = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Post post = new Post(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("content"),
                            rs.getString("image")
                    );
                    posts.add(post);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Could not get users from database", e.getMessage());
        }
        return posts;
    }
}