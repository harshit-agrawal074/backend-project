package com.backendproject.application.mapper;

import org.springframework.stereotype.Component;

import com.backendproject.application.bean.ContentBean;
import com.backendproject.application.entity.Content;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class ContentBeanEntityMapper implements IContentBeanEntityMapper {

	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	private BoundMapperFacade<Content, ContentBean> contentEntityToBeanMapper = mapperFactory.getMapperFacade(Content.class, ContentBean.class);
	private BoundMapperFacade<ContentBean, Content> contentBeanToEntityMapper = mapperFactory.getMapperFacade(ContentBean.class, Content.class);

	@Override
	public ContentBean mapToContentBean(Content content) {
		return contentEntityToBeanMapper.map(content);
	}

	@Override
	public Content mapToContentEntity(ContentBean contentBean) {
		return contentBeanToEntityMapper.map(contentBean);
	}
}
