package br.com.curso_spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
public class OpenApiConfig {
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("RESTful API with JAVA and SpringBoot 3")
						.version("v1")
						.description("https://pub.erudio.com.br/meus-cursos")
						.termsOfService("Description about this API")
						.license(
							new License()
								.name("Apache 2.0")
								.url("https://pub.erudio.com.br/meus-cursos")
							)
						);
	}
}
