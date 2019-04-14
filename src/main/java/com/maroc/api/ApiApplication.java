package com.maroc.api;

import com.maroc.api.dao.UserRepository;
import com.maroc.api.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    @Autowired
    UserRepository userRepository;



    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(org.apache.catalina.User.class); // default api dosnt expose id field

        //Fixtures load
        Users user1 = new Users();
        user1.setFirstname("Albert");
        user1.setLastname("Einsetin");
        userRepository.save(user1);
    }
}
