package ua.knu.exchanger.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StopWatch;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.util.stream.IntStream;

@Slf4j
@Service
@RequiredArgsConstructor
@EnableBinding(Source.class)
@FieldDefaults(makeFinal = true)
@ConditionalOnProperty("cloud.streams.enabled")
public class CloudProducerService {

    private Source source;

    private StopWatch stopWatch;

    @NonFinal
    private String json;

    @Value("${amount-of-messages}")
    private Integer amountOfMessages;

    @Scheduled(initialDelay = 5000, fixedDelay = Integer.MAX_VALUE)
    public void send() {
        var message = MessageBuilder.withPayload(json).build();
        stopWatch.start();
        log.info("Message producing start!");

        IntStream.range(0, amountOfMessages).forEach(i -> source.output().send(message));

        log.info("Message producing finished!");
    }

    @SneakyThrows
    @PostConstruct
    private void postConstruct() {
        this.json = IOUtils.toString(new FileReader(ResourceUtils.getFile("classpath:data/small.json")));
    }
}
