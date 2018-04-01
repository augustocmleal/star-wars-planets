package br.com.augustoleal.starwarsplanets.entity;

import org.springframework.stereotype.Component;
@Component
public class Planet {

	private String id;
	private String nome;
	private String clima;
	private String terreno;
	private Integer aparicoes;
	
	public String getId() {
		return id;
	}
	public void setId(String planetId) {
		this.id = planetId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public String getTerreno() {
		return terreno;
	}
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	public Integer getAparicoes() {
		return aparicoes;
	}
	public void setAparicoes(Integer aparicoes) {
		this.aparicoes = aparicoes;
	}
	@Override
	public String toString() {
		return "Planet [id=" + id + ", nome=" + nome + ", clima=" + clima + ", terreno=" + terreno + ", aparicoes="
				+ aparicoes + "]";
	}
	
	
	
}
