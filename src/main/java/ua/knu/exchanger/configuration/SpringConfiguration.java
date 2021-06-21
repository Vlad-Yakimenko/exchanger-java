package ua.knu.exchanger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.StopWatch;

@Configuration
@EnableScheduling
public class SpringConfiguration {

    @Bean
    public StopWatch stopWatch() {
        return new StopWatch();
    }
}
