package com.backendproject.application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backendproject.application.Category;
import com.backendproject.application.Genre;
import com.backendproject.application.entity.Content;

public interface IContentDao extends JpaRepository<Content, Long> {

	/**
	 * This method is basically to fetch the Content by UUID.
	 * @param contentUuid
	 * @return
	 */
	Optional<Content> readByUuid(String contentUuid);

	/**
	 * This method is to find all Content by Category.
	 * @param category
	 * @return
	 */
	List<Content> findAllByCategory(Category category);

	/**
	 * This method is to find all Content by Genre.
	 * @param genre
	 * @return
	 */
	List<Content> findAllByGenre(Genre genre);

	/**
	 * This method is basically to fetch the Content by name.
	 * @param name
	 * @return
	 */
	Optional<Content> readByName(String name);
}
