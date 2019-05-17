package com.polytech.MavenProject.business;

import java.util.List;

import com.polytech.MavenProject.repository.StoryRepository;

public class FeedServiceImpl implements FeedService {
    private StoryRepository storyRepository;

    public FeedServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public List<Story> fetchAll() {

        return storyRepository.findAll();
    }
   
}
