package com.haydikodlayal.m.springelasticsearchexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class SpringElasticSearchExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringElasticSearchExampleApplication.class, args);
	}

}
