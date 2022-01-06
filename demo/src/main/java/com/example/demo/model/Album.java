package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Album {

	@Id
	private Integer userId;
	
	private Integer id;
	
	private String title;
	
	public Album() {
		
	}

	public Album(Integer userId, Integer id, String title) {
		this.userId = userId;
		this.id = id;
		this.title = title;
	}


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Album [userId=" + userId + ", id=" + id + ", title=" + title + "]";
	}

	
	
}
