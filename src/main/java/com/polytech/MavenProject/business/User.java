package com.polytech.MavenProject.business;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Column(name = "firstname")
    private String firstname;

  
    @Column(name = "lastname")
    private String lastname;
    
    @Column(name = "username", unique = true)
    private String username;

   
    @Column(name = "password")
    private String password;

 
    
}
