package mz.com.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import mz.com.library.service.DbService;

@Configuration
@Profile("dev")
public class TestConfig {

	@Autowired
	private DbService dbService;

	@Bean
	public void instanciaBaseDeDados() {
		this.dbService.instanciaBaseDeDados();
	}
}
