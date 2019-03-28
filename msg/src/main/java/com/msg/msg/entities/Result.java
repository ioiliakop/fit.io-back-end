package com.msg.msg.entities;

import java.util.List;

public class Result {

	private int count;

	private List<?> results;

	public Result() {
	}

	public Result(int count, List<?> results) {
		this.count = count;
		this.results = results;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<?> getResults() {
		return results;
	}

	public void setResults(List<?> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Result [count=" + count + ", results=" + results + "]";
	}

}
