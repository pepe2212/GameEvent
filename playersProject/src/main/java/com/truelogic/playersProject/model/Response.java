package com.truelogic.playersProject.model;

import java.util.List;

import lombok.Data;

@Data
public class Response {

	private List<String>result;

	public List<String> getResult() {
		return result;
	}

	public void setResult(List<String> result) {
		this.result = result;
	}
}
