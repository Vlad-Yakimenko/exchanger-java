package ua.knu.exchanger.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Slf4j
@Service
@RequiredArgsConstructor
@EnableBinding(Sink.class)
@ConditionalOnProperty("cloud.streams.enabled")
public class CloudConsumerService {

    private final StopWatch stopWatch;

    private int amountMessagesToBeConsumed = 100_000;

    @StreamListener(Sink.INPUT)
    public void listenGroupFoo(@Payload String json) {
        if (amountMessagesToBeConsumed == 1) {
            stopWatch.stop();
            log.info("Last message being consumed, total time: {}ms", stopWatch.getLastTaskTimeMillis());
            amountMessagesToBeConsumed = 100_000;
        } else {

            amountMessagesToBeConsumed--;
        }
    }
}
