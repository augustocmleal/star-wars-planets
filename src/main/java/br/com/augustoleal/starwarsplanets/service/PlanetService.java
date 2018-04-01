package br.com.augustoleal.starwarsplanets.service;



import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.augustoleal.starwarsplanets.StarWarsPlanetsConstants;
import br.com.augustoleal.starwarsplanets.entity.Planet;
import br.com.augustoleal.starwarsplanets.repository.PlanetRepository;
import br.com.augustoleal.starwarsplanets.service.to.PlanetServiceResponse;
import br.com.augustoleal.starwarsplanets.service.to.ServiceResponse;
import util.PlanetHelper;

@Service
public class PlanetService {

	
	private static final Logger logger = LoggerFactory.getLogger(PlanetService.class);
	
	@Autowired
	private PlanetRepository repository;
	
	public ServiceResponse insertPlanet(Planet planet){
		
		PlanetHelper.generateHashId(planet);
		
		ServiceResponse response = new ServiceResponse();
		
		try{
			repository.insertPlanet(planet);
			
			response.code = Response.SC_OK;
			response.success = true;
			response.message = StarWarsPlanetsConstants.MENSAGEM_SUCESSO;
		}catch (Exception e) {
			logger.error("Erro ao inserir Planeta: " + e.getMessage());
			
			response.code = Response.SC_INTERNAL_SERVER_ERROR;
			response.success = false;
			response.message = StarWarsPlanetsConstants.MENSAGEM_ERRO;
		}
		
		return response;
	}
	
	public PlanetServiceResponse getPlanets(){
		
		List<Planet> planetList = new ArrayList<Planet>();
		ServiceResponse response = new ServiceResponse();
		
		try{
			planetList = repository.listPlanets();
			
			response.code = Response.SC_OK;
			response.success = true;
			response.message = StarWarsPlanetsConstants.MENSAGEM_SUCESSO;
		}catch (Exception e) {
			logger.error("Erro ao recuperar Planeta: " + e.getMessage());
			
			response.code = Response.SC_INTERNAL_SERVER_ERROR;
			response.success = false;
			response.message = StarWarsPlanetsConstants.MENSAGEM_ERRO;
		}
		
		PlanetServiceResponse serviceResponse = new PlanetServiceResponse(planetList, response);
		
		return serviceResponse;
	}
	
	public PlanetServiceResponse getPlanetById(String id){
		Planet planet = new Planet();
		ServiceResponse response = new ServiceResponse();
		
		try{
			planet = repository.getPlanetById(id);
			
			response.code = Response.SC_OK;
			response.success = true;
			response.message = StarWarsPlanetsConstants.MENSAGEM_SUCESSO;
		}catch (Exception e) {
			logger.error("Erro ao recuperar Planeta: " + e.getMessage());
			
			response.code = Response.SC_INTERNAL_SERVER_ERROR;
			response.success = false;
			response.message = StarWarsPlanetsConstants.MENSAGEM_ERRO;
		}
		
		PlanetServiceResponse serviceResponse = new PlanetServiceResponse(planet, response);
		
		return serviceResponse;
	}
	
	public PlanetServiceResponse getPlanetByNome(String nome){
		
		Planet planet = new Planet();
		ServiceResponse response = new ServiceResponse();
		
		try{
			planet = repository.getPlanetByNome(nome);
			
			response.code = Response.SC_OK;
			response.success = true;
			response.message = StarWarsPlanetsConstants.MENSAGEM_SUCESSO;
		}catch (Exception e) {
			logger.error("Erro ao recuperar Planeta: " + e.getMessage());
			
			response.code = Response.SC_INTERNAL_SERVER_ERROR;
			response.success = false;
			response.message = StarWarsPlanetsConstants.MENSAGEM_ERRO;
		}
		
		PlanetServiceResponse serviceResponse = new PlanetServiceResponse(planet, response);
		
		return serviceResponse;
	}
	
	public ServiceResponse deletePlanetById(String id){
		
		ServiceResponse response = new ServiceResponse();
		try{
			repository.deletePlanetById(id);
			
			response.code = Response.SC_OK;
			response.success = true;
			response.message = StarWarsPlanetsConstants.MENSAGEM_SUCESSO;
		}catch (Exception e) {
			logger.error("Erro ao deletar Planeta: " + e.getMessage());
			
			response.code = Response.SC_INTERNAL_SERVER_ERROR;
			response.success = false;
			response.message = StarWarsPlanetsConstants.MENSAGEM_ERRO;
		}
		
		return response;
	}
	
	
}
