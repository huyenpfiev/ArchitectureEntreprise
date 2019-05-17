package com.polytech.MavenProject.config;


import com.mysql.cj.jdbc.MysqlDataSource;
import com.polytech.MavenProject.business.FeedService;
import com.polytech.MavenProject.business.FeedServiceImpl;
import com.polytech.MavenProject.business.PublicationService;
import com.polytech.MavenProject.business.PublicationServiceImpl;
import com.polytech.MavenProject.repository.JdbcStoryRepository;
import com.polytech.MavenProject.repository.StoryRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    StoryRepository storyRepository() {
        return new JdbcStoryRepository(datasource());
    }

    @Bean
    DataSource datasource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://127.0.0.1:3306/MavenProject?serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("huyendien0978");
        dataSource.setDatabaseName("MavenProject");
        return dataSource;
    }

    @Bean
    PublicationService publicationService() {
        return new PublicationServiceImpl(storyRepository());
    }
    @Bean
    FeedService feedService() {
    	return new FeedServiceImpl(storyRepository());
    }
}
