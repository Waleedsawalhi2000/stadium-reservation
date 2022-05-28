package org.stadium.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.stadium.controller.UserController;
import org.stadium.repository.UserRepository;
import org.stadium.service.UserService;

@Configuration
@Profile("services")
public class ServicesConfiguration {

    @Bean
    public UserController userController() {
        return Mockito.mock(UserController.class);
    }

    @Bean
    public UserService userService() {
        return Mockito.mock(UserService.class);
    }

    @Bean
    public UserRepository userRepository() {
        return Mockito.mock(UserRepository.class);
    }
}
