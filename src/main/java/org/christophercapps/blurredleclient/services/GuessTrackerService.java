package org.christophercapps.blurredleclient.services;

import org.christophercapps.blurredleclient.model.GuessTracker;
import org.springframework.http.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class GuessTrackerService {

    private static final String API_BASE_URL = "https://blurrdle.herokuapp.com/puzzle";
    private final RestTemplate restTemplate = new RestTemplate();

    public GuessTracker getNew() {
        GuessTracker tracker = null;
        return restTemplate.getForObject(API_BASE_URL, GuessTracker.class);
    }

    public GuessTracker makeGuess(String newGuess, GuessTracker tracker) {
        tracker.setGuess(newGuess);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<GuessTracker> entity = new HttpEntity<>(tracker, headers);

        GuessTracker response = null;

        try{
            response = restTemplate.postForObject(API_BASE_URL, entity, GuessTracker.class);
        } catch (Exception e) {
            System.out.println("Error.");
        }

        return response;
    }


}
