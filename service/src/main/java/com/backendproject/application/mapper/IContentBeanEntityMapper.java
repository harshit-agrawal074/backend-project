package com.backendproject.application.mapper;

import com.backendproject.application.bean.ContentBean;
import com.backendproject.application.entity.Content;

public interface IContentBeanEntityMapper {

	/**
	 * Mapping the content entity to Bean
	 * @param content
	 * @return
	 */
	ContentBean mapToContentBean(Content content);

	/**
	 * Mapping the content bean to an Entity
	 * @param contentBean
	 * @return
	 */
	Content mapToContentEntity(ContentBean contentBean);
}
