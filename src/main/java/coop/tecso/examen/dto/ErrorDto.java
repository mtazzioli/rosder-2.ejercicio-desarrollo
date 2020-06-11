package coop.tecso.examen.dto;

import java.util.ArrayList;
import java.util.List;

public class ErrorDto {

	private List<String> description;

	public ErrorDto(String description) {
		List<String> list = new ArrayList<String>();
		list.add(description);
		this.description = list;
	}

	public ErrorDto(List<String> descriptionList) {
		this.description = descriptionList;
	}

	public List<String> getDescription() {
		return description;
	}

	public void setDescription(List<String> description) {
		this.description = description;
	}

}
