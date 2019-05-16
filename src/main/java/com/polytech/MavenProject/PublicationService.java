package com.polytech.MavenProject;

import java.util.List;

public interface PublicationService {
	void share(Story story);
	List<Story> addComment(Comment cmt, Long id);
}
