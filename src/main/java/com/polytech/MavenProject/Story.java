package com.polytech.MavenProject;

import java.util.List;
import java.util.ArrayList;

public class Story {
	private String content;
	private List<Comment> comments=new ArrayList<Comment>();
	private Long id;
    public Story(String content) {

        this.content = content;
        
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setComment(List<Comment> cmt) {
    	this.comments=cmt;
    }
    public List<Comment> getComment() {
    	return comments;
    }
    public void setID(Long id) {
    	this.id=id;
    }
    public Long getID() {
    	return id;
    }

	
	
	@Override
    public String toString() {
        return "Story{" +
                "content='" + content + '\'' +
                '}';
    }
}
