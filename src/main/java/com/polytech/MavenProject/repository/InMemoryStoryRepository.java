//package com.polytech.MavenProject.repository;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.polytech.MavenProject.business.Comment;
//import com.polytech.MavenProject.business.Story;
//
//public class InMemoryStoryRepository implements StoryRepository{
//	private List<Story> stories = new ArrayList<Story>();
//
//    public List<Story> findAll() {
//        return stories;
//    }
//
//    public List<Story> save(Story story) {
//    	
//        stories.add(story);
//        return stories;
//    }
//    public List<Story> addComment(Comment cmt, Long id) {
//    	
//    	for (int i =0; i<stories.size();i++) {
//    		if(stories.get(i).getID()==id) {
//    			List<Comment> cmts=stories.get(i).getComment();
//    			cmts.add(cmt);
//    			stories.get(i).setComment(cmts);
//    		}
//    	}
//    	return stories;
//    }
//    
//}
