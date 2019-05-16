package com.polytech.MavenProject;


import com.mysql.cj.jdbc.MysqlDataSource;
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
