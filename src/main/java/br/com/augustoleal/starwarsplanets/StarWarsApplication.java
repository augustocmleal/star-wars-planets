package br.com.augustoleal.starwarsplanets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = { "br.com.augustoleal.starwarsplanets" })
public class StarWarsApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(StarWarsApplication.class, args);
    }
}
