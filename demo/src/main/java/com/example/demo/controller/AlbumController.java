package com.example.demo.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Album;

@RestController
@RequestMapping("/api/v1/albums")
public class AlbumController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping
	public String getAlbumList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate
				.exchange("https://jsonplaceholder.typicode.com/albums", HttpMethod.GET, entity, String.class)
				.getBody();
	}

	@GetMapping(path = "/{id}")
	public String getAlbumById(@PathVariable("id") Integer id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate
				.exchange("https://jsonplaceholder.typicode.com/albums/" + id, HttpMethod.GET, entity, String.class)
				.getBody();
	}

	@PostMapping
	public String registerAlbum(@RequestBody Album album) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Album> entity = new HttpEntity<Album>(album, headers);

		return restTemplate
				.exchange("https://jsonplaceholder.typicode.com/albums", HttpMethod.POST, entity, String.class)
				.getBody();

	}

	@PutMapping(path = "/{id}")
	public String updateAlbum(@PathVariable("id") Integer id, @RequestBody Album album) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Album> entity = new HttpEntity<Album>(album, headers);

		return restTemplate.exchange("https://jsonplaceholder.typicode.com/albums/" + id, HttpMethod.PUT, entity, String.class)
				.getBody();
	}

	@DeleteMapping(path = "/{id}")
	public String deleteAlbum(@PathVariable("id") Integer id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Album> entity = new HttpEntity<Album>(headers);

		return restTemplate.exchange("https://jsonplaceholder.typicode.com/albums/" + id, HttpMethod.DELETE, entity, String.class)
				.getBody();
	}
}
