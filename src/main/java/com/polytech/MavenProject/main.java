package com.polytech.MavenProject;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
public class main {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AppConfig.class);
        StoryRepository storyRepository = context.getBean(StoryRepository.class);
        storyRepository.save(new Story("MARSEILLE"));
        storyRepository.save(new Story("PARIS"));
        storyRepository.save(new Story("NY"));
        storyRepository.save(new Story("LONDON"));

        List<Story> stories = storyRepository.findAll();
        for (Story story : stories) {
            System.out.println(story.toString());
        }

	}

}
