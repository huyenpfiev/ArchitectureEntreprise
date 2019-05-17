package com.polytech.MavenProject.repository;
import java.util.List;

import com.polytech.MavenProject.business.Comment;
import com.polytech.MavenProject.business.Story;

public interface StoryRepository {
	List<Story> findAll();
	List<Story> save(Story story);
    List<Story> addComment(Comment cmt, Long id);
   
}

