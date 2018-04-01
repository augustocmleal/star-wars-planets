package br.com.augustoleal.starwarsplanets.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

@Repository
public abstract class AbstractRepository {
	private Cluster cluster;
	protected Session session;
	
	@Autowired
    public void setConnection() {
		this.cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		this.session = cluster.connect("starwars");
    }
	
	
}
