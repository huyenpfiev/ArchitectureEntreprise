package com.polytech.MavenProject;
import java.util.ArrayList;
import java.util.List;

public class InMemoryStoryRepository implements StoryRepository{
	private List<Story> stories = new ArrayList<Story>();

    public List<Story> findAll() {
        return stories;
    }

    public void save(Story story) {
    	
        stories.add(story);
    }
    public List<Story> addComment(Comment cmt, Long id) {
    	
    	for (int i =0; i<stories.size();i++) {
    		if(stories.get(i).getID()==id) {
    			List<Comment> cmts=stories.get(i).getComment();
    			cmts.add(cmt);
    			stories.get(i).setComment(cmts);
    		}
    	}
    	return stories;
    }
    
}
