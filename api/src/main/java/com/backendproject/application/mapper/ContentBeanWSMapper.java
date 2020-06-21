package com.backendproject.application.mapper;

import org.springframework.stereotype.Component;

import com.backendproject.application.bean.ContentBean;
import com.backendproject.application.ws.ContentWS;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class ContentBeanWSMapper implements IContentBeanWSMapper {
	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	private BoundMapperFacade<ContentWS, ContentBean> contentWsToBeanMapper = mapperFactory.getMapperFacade(ContentWS.class, ContentBean.class);
	private BoundMapperFacade<ContentBean, ContentWS> contentBeanToWsMapper = mapperFactory.getMapperFacade(ContentBean.class, ContentWS.class);

	@Override
	public ContentBean mapToContentBean(ContentWS contentWs) {
		return contentWsToBeanMapper.map(contentWs);
	}

	@Override
	public ContentWS mapToContentEntity(ContentBean contentBean) {
		return contentBeanToWsMapper.map(contentBean);
	}
}
