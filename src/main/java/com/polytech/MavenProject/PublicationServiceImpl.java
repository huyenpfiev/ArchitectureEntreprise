package com.polytech.MavenProject;

import java.util.List;

public class PublicationServiceImpl implements PublicationService{
	private StoryRepository storyRepository;

    public PublicationServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public void share(Story story) {
        storyRepository.save(story);
    }
    public List<Story> addComment(Comment cmt, Long id) {
    	return storyRepository.addComment(cmt,id);
    }
}

