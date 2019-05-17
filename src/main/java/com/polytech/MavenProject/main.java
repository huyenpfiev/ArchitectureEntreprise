package com.polytech.MavenProject;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.polytech.MavenProject.business.Story;
import com.polytech.MavenProject.config.AppConfig;
import com.polytech.MavenProject.repository.StoryRepository;

import java.util.ArrayList;
import java.util.List;
public class main {

	public static void main(String[] args) {
	      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	      passwordEncoder.encode("1234");
	      System.out.println( passwordEncoder.encode("1234"));      
	}

}
