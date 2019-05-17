package com.polytech.MavenProject.repository;

import com.polytech.MavenProject.business.Comment;
import com.polytech.MavenProject.business.Story;

import javax.persistence.*;
import javax.transaction.Transactional;

import java.util.List;

@Transactional
public class JpaStoryRepository implements StoryRepository {

    @PersistenceContext
    EntityManager entityManager;

    
    public List<Story> findAll() {
    	Query query = entityManager.createQuery("SELECT s FROM Story s");
        return query.getResultList();
    }

    
    public List<Story> save(Story story) {
        entityManager.persist(story);
        return findAll();
    }
    public List<Story> addComment(Comment cmt, Long id){
    	entityManager.createNativeQuery("insert into COMMENTS (idStory,comment)"
    			+ " VALUES ( :a, :b)")
        .setParameter("a", id)
        .setParameter("b", cmt.getComment()).executeUpdate();
    	
        return findAll();

    	
    }

}
