package com.backendproject.application.entity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.backendproject.application.Category;
import com.backendproject.application.Genre;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "content")
public class Content {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CreatedDate
	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@LastModifiedDate
	@Column(name = "modified_on")
	private LocalDateTime modifiedOn;

	@Column(name = "category")
	private Category category;

	@Column(name = "genre")
	private Genre genre;

	@Column(name = "duration")
	private Float duration;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@ElementCollection
	@Column(name = "languages")
	private List<String> languages = new ArrayList<>();

	@Column(name = "rating")
	private Float rating;

	@Column(name = "is_deleted", columnDefinition = "char(1) default 'N'")
	private Boolean isDeleted;

	@ElementCollection
	@Column(name = "casting")
	private List<String> casting = new ArrayList<>();

	@Column(name = "uuid")
	private String uuid;

	@PrePersist
	public void prePersist(){
		uuid = UUID.randomUUID().toString();
		createdOn = LocalDateTime.now(ZoneId.of("EST"));
		modifiedOn = createdOn;
	}
}
