package com.backendproject.application.contentService;

import java.util.List;
import java.util.Optional;

import com.backendproject.application.Category;
import com.backendproject.application.bean.ContentBean;
import com.backendproject.application.Genre;

public interface IContentService {

	Optional<ContentBean> readByUuid(String contentUuid);

	List<ContentBean> findAllByCategory(Category category);

	List<ContentBean> findAllByGenre(Genre genre);

	Optional<ContentBean> saveContent(ContentBean contentBean);

	List<ContentBean> saveAllContent(List<ContentBean> contentBeans);

	List<ContentBean> findAllContent();

	Optional<ContentBean> readByName(String name);
}
