package com.pikai.jsonxml;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public class TestDemo {
	@Test
	public void testJsonRequestResponse() throws IOException, URISyntaxException {
		String url = "http://localhost:8080/employee";
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.set("Accept", "application/json");
		requestHeaders.set("Content-Type", "application/json");

		String jsonStr = "{\"name\":\"Jack\",\"salary\":16000}";

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, requestHeaders);
		String jsonData = restTemplate.postForObject(url, httpEntity, String.class);

		System.out.println(jsonData);
	}

	@Test
	public void testXmlRequestResponse() throws IOException, URISyntaxException {
		String url = "http://localhost:8080/employee";
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.set("Accept", "application/xml");
		requestHeaders.set("Content-Type", "application/xml");
		String xmlStr = "<employeeX><name>Jack</name><salary>16000</salary></employeeX>";

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> httpEntity = new HttpEntity<String>(xmlStr, requestHeaders);
		String xmlData = restTemplate.postForObject(url, httpEntity, String.class);

		System.out.println(xmlData);
	}

}
