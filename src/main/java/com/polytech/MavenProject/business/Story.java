package com.polytech.MavenProject.business;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "story")
public class Story {
	
	@Column(name = "content")
	private String content;
	
	@OneToMany()
    @JoinColumn(name = "idStory")
	private List<Comment> comments=new ArrayList<Comment>();
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
