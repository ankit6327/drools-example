package com.example;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@RefreshScope
public class SpringBootDroolsHelloWorldApp {

	public static final String KIE_SERVICE_NAME = "kieService";

	private static final String RULES_PATH = "/src/main/resources";

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDroolsHelloWorldApp.class, args);

	}

	@Bean
	public KieServices kieService() {
		return KieServices.Factory.get();
	}

	@Bean
	public KieContainer kieContainer(KieServices kieService) {
		return kieService.getKieClasspathContainer();
	}

}
