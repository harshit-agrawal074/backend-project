package com.backendproject.application.ws;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.backendproject.application.Category;
import com.backendproject.application.Genre;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ContentWS {
	private String uuid;
	private Category category;
	private Genre genre;
	private Float duration;
	private String name;
	private String description;
	private String languages;
	private Float rating;
	private Boolean isDeleted;
	private String casting;
}

