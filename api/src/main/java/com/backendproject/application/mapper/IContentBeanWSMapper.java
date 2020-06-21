package com.backendproject.application.mapper;

import com.backendproject.application.bean.ContentBean;
import com.backendproject.application.ws.ContentWS;

public interface IContentBeanWSMapper {

	/**
	 * Mapping the content WS to Bean
	 * @param contentWs
	 * @return
	 */
	ContentBean mapToContentBean(ContentWS contentWs);

	/**
	 * Mapping the content bean to WS
	 * @param contentBean
	 * @return
	 */
	ContentWS mapToContentEntity(ContentBean contentBean);
}
