package com.backendproject.application;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backendproject.application.ws.ContentWS;

public interface IContentApi {

	@RequestMapping(method = RequestMethod.GET,
			value = "/content",
			produces = { "application/json" }
			)
	ResponseEntity<List<ContentWS>> findAllContent();

	@RequestMapping(method = RequestMethod.GET,
			value = "/content/{contentUuid}",
			produces = { "application/json" }
	)
	ResponseEntity<ContentWS> findContentByUuid(@PathVariable("contentUuid") String contentUuid);

	@RequestMapping(method = RequestMethod.GET,
			value = "/content/category/{category}",
			produces = { "application/json" }
			)
	ResponseEntity<List<ContentWS>> findAllContentByCategory(@PathVariable("category") Category category);

	@RequestMapping(method = RequestMethod.GET,
			value = "/content/genre/{genre}",
			produces = { "application/json" }
	)
	ResponseEntity<List<ContentWS>> findAllContentByGenre(@PathVariable("genre") Genre genre);

	@RequestMapping(method = RequestMethod.POST,
			value = "/content",
			produces = { "application/json" },
			consumes = { "application/json" }
	)
	ResponseEntity<ContentWS> saveContent(@RequestBody ContentWS contentWS);

	@RequestMapping(method = RequestMethod.POST,
			value = "/contents",
			produces = { "application/json" },
			consumes = { "application/json" }
	)
	ResponseEntity<List<ContentWS>> saveAllContent(@RequestBody List<ContentWS> contentWS);
}
