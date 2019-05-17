package com.polytech.MavenProject.business;

import java.util.List;

public interface PublicationService {
	List<Story> share(Story story);
	List<Story> addComment(Comment cmt, Long id);
}
