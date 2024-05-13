package ru.example.WebNewsService.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MicroserviceClientCreatorNews {

	private final String baseUrl = "http://localhost:8041/news/api";

	private RestTemplate restTemplate;

	public MicroserviceClientCreatorNews(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String returnEverything() {
		String endpointUrl = baseUrl + "/all";
		return restTemplate.getForObject(endpointUrl, String.class);
	}

	public String returnById(Long id) {
		String endpointUrl = baseUrl + "/" + id;
		return restTemplate.getForObject(endpointUrl, String.class);
	}

	public String returnRandom() {
		String endpointUrl = baseUrl + "/random";
		return restTemplate.getForObject(endpointUrl, String.class);
	}

}
