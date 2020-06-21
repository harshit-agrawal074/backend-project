package com.backendproject.application;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendproject.application.bean.ContentBean;
import com.backendproject.application.contentService.IContentService;
import com.backendproject.application.mapper.IContentBeanWSMapper;
import com.backendproject.application.ws.ContentWS;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ContentApi implements IContentApi {
	private final static String LOCATION = "/api/content/";
	private final IContentBeanWSMapper contentBeanWSMapper;
	private final IContentService contentService;

	@Override
	public ResponseEntity<List<ContentWS>> findAllContent() {
		log.info("Finding all contents.....");
		List<ContentWS> contentWSList = contentService.findAllContent()
				.stream()
				.map(contentBeanWSMapper::mapToContentEntity)
				.collect(Collectors.toList());
		log.info("Found total of {} elements.", contentWSList.size());
		return ResponseEntity.ok().body(contentWSList);
	}

	@Override
	public ResponseEntity<ContentWS> findContentByUuid(String contentUuid) {
		log.info("Finding content by UUID = {}", contentUuid);
		Optional<ContentBean> contentBean = contentService.readByUuid(contentUuid);
		if (contentBean.isPresent()) {
			return ResponseEntity.ok().body(contentBean.map(contentBeanWSMapper::mapToContentEntity).get());
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<ContentWS>> findAllContentByCategory(Category category) {
		log.info("Finding all contents belongs to {} category.....", category);
		List<ContentWS> contentWSList = contentService.findAllByCategory(category)
				.stream()
				.map(contentBeanWSMapper::mapToContentEntity)
				.collect(Collectors.toList());
		log.info("Found total of {} elements.", contentWSList.size());
		return ResponseEntity.ok().body(contentWSList);
	}

	@Override
	public ResponseEntity<List<ContentWS>> findAllContentByGenre(Genre genre) {
		log.info("Finding all contents belongs to {} genre.....", genre);
		List<ContentWS> contentWSList = contentService.findAllByGenre(genre)
				.stream()
				.map(contentBeanWSMapper::mapToContentEntity)
				.collect(Collectors.toList());
		log.info("Found total of {} elements.", contentWSList.size());
		return ResponseEntity.ok().body(contentWSList);
	}

	@Override
	public ResponseEntity<ContentWS> saveContent(ContentWS contentWS) {
		log.info("Checking if the content exists with name {}.....", contentWS.getName());
		if (contentService.readByName(contentWS.getName()).isPresent()) {
			log.info("Content found with name {}.....", contentWS.getName());
			return ResponseEntity.badRequest().build();
		}
		log.info("Saving the content with name {}.....", contentWS.getName());
		Optional<ContentBean> contentBean = contentService.saveContent(contentBeanWSMapper.mapToContentBean(contentWS));
		return ResponseEntity.created(URI.create(LOCATION + contentBean.get().getUuid()))
				.body(contentBeanWSMapper.mapToContentEntity(contentBean.get()));
	}

	@Override
	public ResponseEntity<List<ContentWS>> saveAllContent(List<ContentWS> contentWS) {
		log.info("Saving all the contents given....");
		return ResponseEntity.created(URI.create(LOCATION))
				.body(contentService.saveAllContent(contentWS.
						stream()
						.map(contentBeanWSMapper::mapToContentBean)
						.collect(Collectors.toList()))
						.stream()
						.map(contentBeanWSMapper::mapToContentEntity)
						.collect(Collectors.toList()));
	}
}
