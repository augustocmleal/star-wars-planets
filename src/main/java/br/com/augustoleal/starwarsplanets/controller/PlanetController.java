package br.com.augustoleal.starwarsplanets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.augustoleal.starwarsplanets.entity.Planet;
import br.com.augustoleal.starwarsplanets.service.PlanetService;
import br.com.augustoleal.starwarsplanets.service.to.PlanetServiceResponse;
import br.com.augustoleal.starwarsplanets.service.to.ServiceResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/starwars")
public class PlanetController {
	
	@Autowired
	private PlanetService service;
	
	@ApiOperation(
			value="Cadastrar um novo planeta", 
			response=ServiceResponse.class, 
			notes="Essa operação salva um novo registro com as informações do planeta.")
	@ApiResponses(value= {
			@ApiResponse(
					code=200, 
					message="Retorna um ServiceResponse com uma mensagem de sucesso",
					response=ServiceResponse.class
					),
			@ApiResponse(
					code=500, 
					message="Caso tenhamos algum erro vamos retornar um ServiceResponse com mensagem de erro interno",
					response=ServiceResponse.class
					)
	})
	@PostMapping(value = "/planets/insert")
	public ServiceResponse insertplanet(@RequestBody Planet planet){
		return service.insertPlanet(planet);
	}
	
	@ApiOperation(
			value="Retorna todos os planetas contidos no banco", 
			response=ServiceResponse.class, 
			notes="Essa operação retorna as informações de todos os planetas contidos no banco.")
	@ApiResponses(value= {
			@ApiResponse(
					code=200, 
					message="Retorna um PlanetServiceResponse com uma mensagem de sucesso e a lista de planetas",
					response=ServiceResponse.class
					),
			@ApiResponse(
					code=500, 
					message="Caso tenhamos algum erro vamos retornar um PlanetServiceResponse com mensagem de erro interno",
					response=ServiceResponse.class
					)
	})
	@GetMapping(value = "/planets")
	public PlanetServiceResponse getPlanets(){
		return service.getPlanets();
	}
	
	@ApiOperation(
			value="Consulta um planeta baseado em seu id", 
			response=PlanetServiceResponse.class, 
			notes="Essa operação retorna as informações de um planeta contido no banco.")
	@ApiResponses(value= {
			@ApiResponse(
					code=200, 
					message="Retorna um PlanetServiceResponse com uma mensagem de sucesso e a lista de planetas",
					response=PlanetServiceResponse.class
					),
			@ApiResponse(
					code=500, 
					message="Caso tenhamos algum erro vamos retornar um PlanetServiceResponse com mensagem de erro interno",
					response=PlanetServiceResponse.class
					)
	})
	@GetMapping(value = "/planets/id/{id}")
	public PlanetServiceResponse getPlanetById(@PathVariable String id){
		return service.getPlanetById(id);
	}
	
	@ApiOperation(
			value="Consulta um planeta baseado em seu nome", 
			response=PlanetServiceResponse.class, 
			notes="Essa operação retorna as informações de um planeta contido no banco.")
	@ApiResponses(value= {
			@ApiResponse(
					code=200, 
					message="Retorna um PlanetServiceResponse com uma mensagem de sucesso e a lista de planetas",
					response=PlanetServiceResponse.class
					),
			@ApiResponse(
					code=500, 
					message="Caso tenhamos algum erro vamos retornar um PlanetServiceResponse com mensagem de erro interno",
					response=PlanetServiceResponse.class
					)
	})
	@GetMapping(value = "/planets/nome/{nome}")
	public PlanetServiceResponse getPlanetByNome(@PathVariable String nome){
		return service.getPlanetByNome(nome);
	}
	
	@ApiOperation(
			value="Deleta um planeta baseado em seu id", 
			response=ServiceResponse.class, 
			notes="Essa operação deleta as informações de um planeta contido no banco.")
	@ApiResponses(value= {
			@ApiResponse(
					code=200, 
					message="Retorna um ServiceResponse com uma mensagem de sucesso e a lista de planetas",
					response=ServiceResponse.class
					),
			@ApiResponse(
					code=500, 
					message="Caso tenhamos algum erro vamos retornar um ServiceResponse com mensagem de erro interno",
					response=ServiceResponse.class
					)
	})
	@DeleteMapping(value = "/planets/delete/{id}")
	public ServiceResponse deletePlanetById(@PathVariable String id){
		return service.deletePlanetById(id);
	}
	
	
	
	

}
