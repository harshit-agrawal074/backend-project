package com.backendproject.application.convertor;

import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeConverter;

public class ListOfStringConvertor implements AttributeConverter<List<String>, String> {

	@Override
	public String convertToDatabaseColumn(List<String> attribute) {
		return String.join(", ", attribute);
	}

	@Override
	public List<String> convertToEntityAttribute(String dbData) {
		return Arrays.asList(dbData.split(", "));
	}
}
