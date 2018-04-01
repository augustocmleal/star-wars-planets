package br.com.augustoleal.starwarsplanets;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.augustoleal.starwarsplanets.entity.Planet;
import br.com.augustoleal.starwarsplanets.service.PlanetService;
import br.com.augustoleal.starwarsplanets.service.to.PlanetServiceResponse;
import br.com.augustoleal.starwarsplanets.service.to.ServiceResponse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PlanetServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(PlanetServiceTest.class);
	
	@Autowired
	private PlanetService service;
	
	@Test
	public void insertTest(){
		logger.info("----------   Iniciando Teste > insertTest   ----------");
		
		Planet planet = new Planet();
		
		planet.setNome("Jurujuba");
		planet.setClima("Quente");
		planet.setTerreno("maritmo");
		
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse = service.insertPlanet(planet);
		
		Assert.assertEquals(HttpStatus.OK, HttpStatus.valueOf(serviceResponse.code));
		Assert.assertTrue(serviceResponse.success);
		
		logger.info("----------   Finalizando Teste > insertTest   ----------");
	}
	
	@Test
	public void getPlanetsTest(){
		logger.info("----------   Iniciando Teste > getPlanetsTest   ----------");
		
		PlanetServiceResponse planetServiceResponse = new PlanetServiceResponse();
		
		planetServiceResponse = service.getPlanets();
		
		Assert.assertEquals(HttpStatus.OK, HttpStatus.valueOf(planetServiceResponse.code));
		Assert.assertTrue(planetServiceResponse.success);
		
		logger.info("----------   Finalizando Teste > getPlanetsTest   ----------");
	}
	
	@Test
	public void getPlanetByIdTest(){
		logger.info("----------   Iniciando Teste > getPlanetByIdTest   ----------");
		
		Planet planet = new Planet();
		
		planet.setNome("Planeta Teste 1");
		planet.setClima("Quente");
		planet.setTerreno("Maritmo");
		
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse = service.insertPlanet(planet);
		
		Assert.assertEquals(HttpStatus.OK, HttpStatus.valueOf(serviceResponse.code));
		Assert.assertTrue(serviceResponse.success);
		
		PlanetServiceResponse planetServiceResponse = new PlanetServiceResponse();
		planetServiceResponse = service.getPlanetById(planet.getId());
		
		Assert.assertEquals(HttpStatus.OK, HttpStatus.valueOf(planetServiceResponse.code));
		Assert.assertTrue(planetServiceResponse.success);
		
		logger.info("----------   Finalizando Teste > getPlanetByIdTest   ----------");
	}
	
	@Test
	public void getPlanetByNomeTest(){
		logger.info("----------   Iniciando Teste > getPlanetByNomeTest   ----------");
		
		Planet planet = new Planet();
		
		planet.setNome("Planeta Teste 2");
		planet.setClima("Quente");
		planet.setTerreno("Maritmo");
		
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse = service.insertPlanet(planet);
		
		Assert.assertEquals(HttpStatus.OK, HttpStatus.valueOf(serviceResponse.code));
		Assert.assertTrue(serviceResponse.success);
		
		PlanetServiceResponse planetServiceResponse = new PlanetServiceResponse();
		planetServiceResponse = service.getPlanetByNome(planet.getNome());
		
		Assert.assertEquals(HttpStatus.OK, HttpStatus.valueOf(planetServiceResponse.code));
		Assert.assertTrue(planetServiceResponse.success);
		
		logger.info("----------   Finalizando Teste > getPlanetByNomeTest   ----------");
	}
	
	@Test
	public void deletePlanetByIdTest(){
		logger.info("----------   Iniciando Teste > deletePlanetByIdTest   ----------");
		
		Planet planet = new Planet();
		
		planet.setNome("Planeta Teste 3");
		planet.setClima("Quente");
		planet.setTerreno("Maritmo");
		
		ServiceResponse insertServiceResponse = new ServiceResponse();
		insertServiceResponse = service.insertPlanet(planet);
		
		Assert.assertEquals(HttpStatus.OK, HttpStatus.valueOf(insertServiceResponse.code));
		Assert.assertEquals(insertServiceResponse.success, true);
		
		ServiceResponse deleteServiceResponse = new ServiceResponse();
		deleteServiceResponse = service.deletePlanetById(planet.getId());
		
		Assert.assertEquals(HttpStatus.OK, HttpStatus.valueOf(deleteServiceResponse.code));
		Assert.assertEquals(deleteServiceResponse.success, true);
		
		logger.info("----------   Finalizando Teste > deletePlanetByIdTest   ----------");
	}
}
