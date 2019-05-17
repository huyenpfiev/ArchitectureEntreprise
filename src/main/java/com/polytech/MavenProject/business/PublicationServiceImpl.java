package com.polytech.MavenProject.business;

import java.util.List;

import com.polytech.MavenProject.repository.StoryRepository;

public class PublicationServiceImpl implements PublicationService{
	private StoryRepository storyRepository;

    public PublicationServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public List<Story> share(Story story) {
         return storyRepository.save(story);
    }
    public List<Story> addComment(Comment cmt, Long id) {
    	return storyRepository.addComment(cmt,id);
    }
}

