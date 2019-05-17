package com.polytech.MavenProject.repository;

import javax.sql.DataSource;

import com.polytech.MavenProject.business.Comment;
import com.polytech.MavenProject.business.Story;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcStoryRepository implements StoryRepository {


    private DataSource dataSource;

    public JdbcStoryRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

   
    public List<Story> findAll() {

        List<Story> results = new ArrayList();
        try {
            //GET CONNECTION
            Connection connection = dataSource.getConnection();
            String sql = "SELECT * FROM STORY";
            //EXECUTE QUERY
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            // FOR EACH ROW IN DATA BASE
            while (resultSet.next()) {
                // I GET THE CONTENT COLUMN
                String content = resultSet.getString("CONTENT");
                Long id =resultSet.getLong("ID");
                List<Comment> comments=findComments(id);
                Story story = new Story(content);
                story.setComment(comments);
                story.setID(id);
                // I ADD THE STORY TO THE RESULT
                results.add(story);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
    
    public List<Comment> findComments(Long id) {

        List<Comment> results = new ArrayList();
        try {
            //GET CONNECTION
            Connection connection = dataSource.getConnection();
            String sql = "SELECT * FROM COMMENTS,STORY WHERE COMMENTS.IDSTORY=STORY.ID AND COMMENTS.IDSTORY="+id+"";
            //EXECUTE QUERY
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            // FOR EACH ROW IN DATA BASE
            while (resultSet.next()) {
                // I GET THE CONTENT COLUMN
                String comment = resultSet.getString("COMMENT");
                Comment cmt = new Comment(comment);
                // I ADD THE STORY TO THE RESULT
                results.add(cmt);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    
    public List<Story>save(Story story) {
        try {
            //GET CONNECTION
            Connection connection = dataSource.getConnection();
            String sql = "INSERT INTO STORY(CONTENT) VALUES('" + story.getContent() + "')";
            //EXECUTE QUERY
            connection.createStatement().execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findAll();
    }
    
    public List<Story> addComment(Comment cmt, Long id) {
        try {
            //GET CONNECTION
            Connection connection = dataSource.getConnection();
            String sql = "INSERT INTO COMMENTS(IDSTORY,COMMENT) VALUES("+id+",'" + cmt.getComment() + "')";
            //EXECUTE QUERY
            connection.createStatement().execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findAll();
    }
}