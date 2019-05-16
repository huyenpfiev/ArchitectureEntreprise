package com.polytech.MavenProject;
import java.util.List;

public interface StoryRepository {
	List<Story> findAll();
    void save(Story story);
    List<Story> addComment(Comment cmt, Long id);
   
}

