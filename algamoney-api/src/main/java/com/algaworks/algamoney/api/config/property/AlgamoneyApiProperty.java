package com.algaworks.algamoney.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@ConfigurationProperties("algamoney")
public class AlgamoneyApiProperty {
	
	@Setter
	private String originAllowed = "http://localhost:8000";
	
	private final Seguranca seguranca = new Seguranca();
	
	@Getter
	@Setter
	public static class Seguranca {
	
		private boolean enableHttps;
		
	}
	
}
