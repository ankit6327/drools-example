package com.example.service.example;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.service.example.beans.JsonRootBean;

public class SendTestCall {
	
	

	static String URL = "https://dev-api.camvio.cloud/aboss-api/rest/v1/accounts?searchType=ACCOUNT+NUMBER&term=8135";

	public static void main(String[] args) {
		Integer accountNum = 0;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
	//	InetSocketAddress host = InetSocketAddress.createUnresolved("localhost", 8080);
		//  headers.setHost(host);
		//headers.set("Host", "dev-api.camvio.cloud");
		//headers.set("Accept", "*/*");
	 //headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36");
	 //headers.set("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
		//headers.add("X-API-Token", "IQpGaVfcE2VPEzSlyTte0d1BvfxXmWcEsd7p6HWr");
		//headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("x-api-token", "IQpGaVfcE2VPEzSlyTte0d1BvfxXmWcEsd7p6HWr");
		//headers.set
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("term", accountNum);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		try {
			
			UriComponentsBuilder.fromUriString(URL).queryParam("term", "");
			
			
			
			JsonRootBean string = restTemplate.exchange(URL, HttpMethod.GET, entity,JsonRootBean.class).getBody();
			System.out.println(string + "   ::  ");
		} catch (RestClientException e) {
			e.printStackTrace();
		}

	}

}
