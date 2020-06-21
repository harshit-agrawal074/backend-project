package com.backendproject.application.bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
public class ContentBean {
	private Long id;
	private LocalDateTime createdOn;
	private LocalDateTime modifiedOn;
	private Category category;
	private Genre genre;
	private Float duration;
	private String name;
	private String description;
	private List<String> languages = new ArrayList<>();
	private Float rating;
	private Boolean isDeleted;
	private List<String> casting = new ArrayList<>();
	private String uuid;
}
