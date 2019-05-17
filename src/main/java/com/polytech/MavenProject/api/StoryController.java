package com.polytech.MavenProject.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.polytech.MavenProject.jsonConvert;
import com.polytech.MavenProject.business.Comment;
import com.polytech.MavenProject.business.FeedService;
import com.polytech.MavenProject.business.PublicationService;
import com.polytech.MavenProject.business.Story;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StoryController {


    @Autowired
    PublicationService publicationService;

    @Autowired
    FeedService feedService;

    @PostMapping("/story")
    public List<Story> share(@RequestBody String content) {
    	
        return publicationService.share(new Story(content));
    }
    
    @PostMapping("/addComment")
    public List<Story> addComment(@RequestBody jsonConvert data) {
    	Comment cmt=data.getCmt();
    	Long id=data.getId();
        return publicationService.addComment(cmt,id);
    }

    @GetMapping("/feed")
    public List<Story> feed() {
        return feedService.fetchAll();
    }
    
    

//    @GetMapping("/toto")
//    public void toto(@RequestParam("param1") Long param1, @RequestParam("param2") String param2) {
//        System.out.println("");
//    }


}