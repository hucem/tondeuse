package com.neosoft.tondeuse.infrastructure.config;

import com.neosoft.tondeuse.domain.service.MowerService;
import com.neosoft.tondeuse.domain.service.impl.MowerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TondeuseConfiguration {

    @Bean
    public MowerService getMowerService() {
        return new MowerServiceImpl();
    }

}
