package com.maroc.api;

import com.maroc.api.dao.UsersRepository;
import com.maroc.api.fixtures.UsersFixture;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

    private final RepositoryRestConfiguration repositoryRestConfiguration;
    final private UsersRepository usersRepository;

    public ApiApplication(UsersRepository usersRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
        this.usersRepository = usersRepository;
        this.repositoryRestConfiguration = repositoryRestConfiguration;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(org.apache.catalina.User.class); // default api dosnt expose id field

        //Fixtures load

        // Users data fixtures
        UsersFixture usersFixture = new UsersFixture(usersRepository);
        usersFixture.insert();
    }
}
