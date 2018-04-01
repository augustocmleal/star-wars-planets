package br.com.augustoleal.starwarsplanets.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import br.com.augustoleal.starwarsplanets.entity.Planet;

@Repository
public class PlanetRepository extends AbstractRepository{
	
	private static final Logger logger = LoggerFactory.getLogger(PlanetRepository.class);
	
	public void insertPlanet(Planet planet){
		logger.info("----------   Iniciando > PlanetRepository > Insert   ----------");
		
		String cql = "";
				
		if(planet.getAparicoes() != null){
			cql = "INSERT INTO starwars.planets (id, nome, clima, terreno, aparicoes) "
					+ "VALUES ('"+ planet.getId() +"', '"+ planet.getNome() +"', '"+ planet.getClima() +"', '"+ planet.getTerreno() + "',"+ planet.getAparicoes() +") IF NOT EXISTS;";
		}else{
			cql = "INSERT INTO starwars.planets (id, nome, clima, terreno) "
					+ "VALUES ('"+ planet.getId() +"', '"+ planet.getNome() +"', '"+ planet.getClima() +"', '"+ planet.getTerreno()+"')IF NOT EXISTS;";
		}
		session.execute(cql);
		
		logger.info("----------   Finalizando > PlanetRepository > Insert   ----------");
	}
	
	public List<Planet> listPlanets(){
		
		logger.info("----------   Iniciando > PlanetRepository > listPlanets   ----------");
		
		ResultSet results = session.execute("SELECT * FROM starwars.planets");
		List<Planet> planetList = new ArrayList<Planet>();
		for (Row row : results) {
			Planet planet = new Planet();
			planet.setId(row.getString("id"));
			planet.setNome(row.getString("nome"));
			planet.setClima(row.getString("clima"));
			planet.setTerreno(row.getString("terreno"));
			planet.setAparicoes(row.getInt("aparicoes"));
			planetList.add(planet);
		}
		
		logger.info("----------   Finalizando > PlanetRepository > listPlanets   ----------");
		
		return planetList;
		
	}
	
	public Planet getPlanetById(String id){
		logger.info("----------   Iniciando > PlanetRepository > getPlanetById   ----------");
		
		ResultSet results = session.execute("SELECT * FROM starwars.planets where id = '" + id +"'" );
		
		Planet planet = new Planet();
		for (Row row : results) {
			planet.setId(row.getString("id"));
			planet.setNome(row.getString("nome"));
			planet.setClima(row.getString("clima"));
			planet.setTerreno(row.getString("terreno"));
			planet.setAparicoes(row.getInt("aparicoes"));
		}
		
		logger.info("----------   Finalizando > PlanetRepository > getPlanetById   ----------");
		
		return planet;
	}
	
	public Planet getPlanetByNome(String nome){
		logger.info("----------   Iniciando > PlanetRepository > getPlanetByNome   ----------");
		
		ResultSet results = session.execute("SELECT * FROM starwars.planets where nome = '" + nome +"' ALLOW FILTERING;" );
		
		Planet planet = new Planet();
		for (Row row : results) {
			planet.setId(row.getString("id"));
			planet.setNome(row.getString("nome"));
			planet.setClima(row.getString("clima"));
			planet.setTerreno(row.getString("terreno"));
			planet.setAparicoes(row.getInt("aparicoes"));
		}
		
		logger.info("----------   Finalizando > PlanetRepository > getPlanetByNome   ----------");
		
		return planet;
	}
	
	public void deletePlanetById(String id){
		logger.info("----------   Iniciando > PlanetRepository > deletePlanetById   ----------");
		
		session.execute("DELETE FROM starwars.planets where id = '" + id +"'" );
		
		logger.info("----------   Finalizando > PlanetRepository > deletePlanetById   ----------");
	}
	
	
}
