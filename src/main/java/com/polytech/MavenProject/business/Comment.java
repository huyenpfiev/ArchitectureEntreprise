package com.polytech.MavenProject.business;
import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
	
	@Id
    @Column(name = "id")
    private Long id;
	
	@Column(name = "comment")
	private String comment;
	
	public Comment(String comment) {
		
		this.comment=comment;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
