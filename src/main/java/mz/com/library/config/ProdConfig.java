package mz.com.library.config;

import mz.com.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdConfig {
	@Autowired
	private DbService dbService;

	@Value("{$spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	public boolean instanciaBaseDeDados() {
		if (strategy.equals("create-drop")) {
			this.dbService.instanciaBaseDeDados();
		}
		return false;
	}

}
