package org.alohome.rates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@Autowired
    private Environment config;

	@Bean
	public Util ratesUtil() {
		return new Util();
	}

	@Bean
	public APIClient RatesAPIClient() {
		return new APIClient();
	}

	@Bean
	public RestTemplate RestTemplate() {
		return new RestTemplateBuilder()
				.basicAuthentication(config.getProperty("auth.login"), config.getProperty("auth.password"))
				.defaultHeader("Content-Type", "application/json")
				.errorHandler(new ErrorHandler())
				.build();
	}
}
