package com.backendproject.application.contentService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.backendproject.application.Category;
import com.backendproject.application.Genre;
import com.backendproject.application.bean.ContentBean;
import com.backendproject.application.dao.IContentDao;
import com.backendproject.application.mapper.IContentBeanEntityMapper;

@Service
@RequiredArgsConstructor
public class ContentService implements IContentService {
	private final IContentDao contentDao;
	private final IContentBeanEntityMapper contentBeanEntityMapper;

	@Override
	public Optional<ContentBean> readByUuid(String contentUuid) {
		return contentDao.readByUuid(contentUuid)
				.map(contentBeanEntityMapper::mapToContentBean);
	}

	@Override
	public List<ContentBean> findAllByCategory(Category category) {
		return contentDao.findAllByCategory(category)
				.stream()
				.map(contentBeanEntityMapper::mapToContentBean)
				.collect(Collectors.toList());
	}

	@Override
	public List<ContentBean> findAllByGenre(Genre genre) {
		return contentDao.findAllByGenre(genre)
				.stream()
				.map(contentBeanEntityMapper::mapToContentBean)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<ContentBean> saveContent(ContentBean contentBean) {
		return Optional.ofNullable(contentDao.save(contentBeanEntityMapper.mapToContentEntity(contentBean)))
				.map(contentBeanEntityMapper::mapToContentBean);
	}

	@Override
	public List<ContentBean> saveAllContent(List<ContentBean> contentBeans) {
		return contentBeans.stream()
				.map(contentBeanEntityMapper::mapToContentEntity)
				.map(contentDao::save)
				.map(contentBeanEntityMapper::mapToContentBean)
				.collect(Collectors.toList());
	}

	@Override
	public List<ContentBean> findAllContent() {
		return contentDao.findAll()
				.stream()
				.map(contentBeanEntityMapper::mapToContentBean)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<ContentBean> readByName(String name) {
		return contentDao.readByName(name)
				.map(contentBeanEntityMapper::mapToContentBean);
	}
}
