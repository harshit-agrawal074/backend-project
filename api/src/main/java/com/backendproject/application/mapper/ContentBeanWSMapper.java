package com.backendproject.application.mapper;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.backendproject.application.bean.ContentBean;
import com.backendproject.application.ws.ContentWS;

@Component
public class ContentBeanWSMapper implements IContentBeanWSMapper {
//	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
//	private BoundMapperFacade<ContentWS, ContentBean> contentWsToBeanMapper = mapperFactory.getMapperFacade(ContentWS.class, ContentBean.class);
//	private BoundMapperFacade<ContentBean, ContentWS> contentBeanToWsMapper = mapperFactory.getMapperFacade(ContentBean.class, ContentWS.class);

	@Override
	public ContentBean mapToContentBean(ContentWS contentWs) {
		return ContentBean.builder()
				.name(contentWs.getName())
				.casting(Arrays.asList(contentWs.getCasting().split(",")))
				.category(contentWs.getCategory())
				.description(contentWs.getDescription())
				.duration(contentWs.getDuration())
				.genre(contentWs.getGenre())
				.languages(Arrays.asList(contentWs.getLanguages().split(",")))
				.rating(contentWs.getRating())
				.build();
	}

	@Override
	public ContentWS mapToContentEntity(ContentBean contentBean) {
		return ContentWS.builder()
				.uuid(contentBean.getUuid())
				.name(contentBean.getName())
				.casting(String.join(",", contentBean.getCasting()))
				.category(contentBean.getCategory())
				.description(contentBean.getDescription())
				.duration(contentBean.getDuration())
				.genre(contentBean.getGenre())
				.languages(String.join(",", contentBean.getLanguages()))
				.rating(contentBean.getRating())
				.build();
	}
}
