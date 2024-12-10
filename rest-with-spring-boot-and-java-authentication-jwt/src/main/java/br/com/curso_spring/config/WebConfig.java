package br.com.curso_spring.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.curso_spring.serialization_converter.YamlJackson2HttpMessageConverter;


@Configuration
public class WebConfig implements WebMvcConfigurer{



	private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");

	@Value("${cors.originsPatterns:default}")
	private String corsOriginsPatterns = "";

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlJackson2HttpMessageConverter());
	}


	@Override
	public void addCorsMappings(CorsRegistry registry) {
		var allowedOrigins = corsOriginsPatterns.split(",");
		registry.addMapping("/**")
			.allowedMethods("*")
			.allowedOrigins(allowedOrigins)
		.allowCredentials(true);
	}



	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		// https://www.baeldung.com/spring-mvc-content-negotiation-json-xml
		// via EXTENTION. localhost:8080/api/person/v1.xml DEPRECATED on SpringBoot 2

		// via QUERY PARAM. localhost:8080/api/person/v1?mediaType=xml

//		configurer.favorParameter(true)
//			.parameterName("mediaType").ignoreAcceptHeader(true)
//			.useRegisteredExtensionsOnly(false)
//			.defaultContentType(MediaType.APPLICATION_JSON)
//				.mediaType("json", MediaType.APPLICATION_JSON)
//				.mediaType("xml", MediaType.APPLICATION_XML);

		// via HEADER PARAM. localhost:8080/api/person/v1

		configurer.favorParameter(false)
		.ignoreAcceptHeader(false)
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
			.mediaType("json", MediaType.APPLICATION_JSON)
			.mediaType("xml", MediaType.APPLICATION_XML)
			.mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML);
	}

}
