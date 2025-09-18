package ru.practicum.ewm.client;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.MaxAttemptsRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import ru.practicum.stat.dto.EndpointHit;
import ru.practicum.stat.dto.ViewStats;

import java.util.List;

@Slf4j
@Component
public class StatsClient {

    private static final String SERVICE_ID = "stat-server";

    private final DiscoveryClient discoveryClient;
    private final RetryTemplate retryTemplate;
    private RestClient restClient;

    public StatsClient(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;

        this.retryTemplate = new RetryTemplate();
        FixedBackOffPolicy backOff = new FixedBackOffPolicy();
        backOff.setBackOffPeriod(3000L);
        retryTemplate.setBackOffPolicy(backOff);

        MaxAttemptsRetryPolicy retryPolicy = new MaxAttemptsRetryPolicy();
        retryPolicy.setMaxAttempts(5);
        retryTemplate.setRetryPolicy(retryPolicy);

        log.info("StatsClient initialized.");
    }

    private RestClient getRestClient() {
        if (restClient == null) {
            String url = retryTemplate.execute(ctx -> {
                var instances = discoveryClient.getInstances(SERVICE_ID);
                if (instances != null && !instances.isEmpty()) {
                    var instance = instances.get(0);
                    return "http://" + instance.getHost() + ":" + instance.getPort();
                }
                throw new RuntimeException("Stats service not found yet");
            });
            restClient = RestClient.create(url);
            log.info("RestClient created with URL: {}", url);
        }
        return restClient;
    }

    public void hit(@Valid EndpointHit hitDto) {
        log.info("Sending hit: {}", hitDto);
        retryTemplate.execute(ctx -> getRestClient().post().uri("/hit")
                .contentType(MediaType.APPLICATION_JSON)
                .body(hitDto)
                .retrieve()
                .toBodilessEntity());
    }

    public List<ViewStats> getStats(String start, String end, List<String> uris, Boolean unique) {
        return retryTemplate.execute(ctx -> getRestClient().get()
                .uri(uriBuilder -> uriBuilder
                        .path("/stats")
                        .queryParam("start", start)
                        .queryParam("end", end)
                        .queryParam("uris", uris)
                        .queryParam("unique", unique)
                        .build())
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                }));
    }
}