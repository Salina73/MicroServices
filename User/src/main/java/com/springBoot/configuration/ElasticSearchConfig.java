package com.springBoot.configuration;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class ElasticSearchConfig {

	@Value("${elasticsearch.host}")
	private String elasticsearchHost;

	@Bean(destroyMethod = "close")
	public RestHighLevelClient client() {
		RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost(elasticsearchHost)));
		return client;
	}
}