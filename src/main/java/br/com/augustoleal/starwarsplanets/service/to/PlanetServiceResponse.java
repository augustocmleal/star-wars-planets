package br.com.augustoleal.starwarsplanets.service.to;

import java.util.List;

import br.com.augustoleal.starwarsplanets.entity.Planet;


public class PlanetServiceResponse extends AbstractServiceResponse{

	public Planet planet;
	
	public List<Planet> planetList;
	
	public PlanetServiceResponse(List<Planet> planetList, ServiceResponse response) {
		this.planetList = planetList;
		super.code = response.code;
		super.success = response.success;
		super.message = response.message;
	}
	
	public PlanetServiceResponse() {
	}
	
	public PlanetServiceResponse(Planet planet, ServiceResponse response) {
		this.planet = planet;
		super.code = response.code;
		super.success = response.success;
		super.message = response.message;
	}
	
	
}
