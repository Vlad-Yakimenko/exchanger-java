package ua.knu.exchanger.configuration;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfiguration {

//    @Value(value = "${kafka.bootstrap.address}")
//    private String bootstrapAddress;
//
//    @Value(value = "${kafka.standard.topic}")
//    private String standardTopic;

//    @Bean
//    public KafkaAdmin kafkaAdmin() {
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//        return new KafkaAdmin(configs);
//    }
//
//    @Bean
//    public NewTopic standardTopic() {
//        return new NewTopic(standardTopic, 1, (short) 1);
//    }
}
