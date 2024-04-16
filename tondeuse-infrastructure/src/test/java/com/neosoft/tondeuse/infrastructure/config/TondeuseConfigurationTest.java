package com.neosoft.tondeuse.infrastructure.config;

import com.neosoft.tondeuse.domain.service.MowerService;
import com.neosoft.tondeuse.domain.service.impl.MowerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes ={com.neosoft.tondeuse.infrastructure.config.TondeuseConfiguration.class})
public class TondeuseConfigurationTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        assertNotNull(context, "Application context should be loaded");
    }

    @Test
    void mowerServiceBeanIsProvided() {
        MowerService mowerService = context.getBean(MowerService.class);
        assertNotNull(mowerService, "MowerService bean should be available");
        assertTrue(mowerService instanceof MowerServiceImpl, "MowerService bean should be an instance of MowerServiceImpl");
    }
}