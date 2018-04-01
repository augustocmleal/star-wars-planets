package br.com.augustoleal.starwarsplanets.service.to;

import org.springframework.stereotype.Component;

@Component
public class ServiceResponse {
	public Integer code;
	public Boolean success;
	public String message;
}
