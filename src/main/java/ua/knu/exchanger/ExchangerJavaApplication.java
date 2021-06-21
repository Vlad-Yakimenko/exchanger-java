package ua.knu.exchanger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class ExchangerJavaApplication implements CommandLineRunner {

//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;

//    @Value(value = "${kafka.standard.topic}")
//    private String standardTopic;

    public static void main(String[] args) {
        SpringApplication.run(ExchangerJavaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        kafkaTemplate.send(standardTopic, "something else");
    }
}
