package b.softuni.surfApp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslationService {

        private final RestTemplate restTemplate;
        private final String libreTranslateUrl;

        public TranslationService(RestTemplate restTemplate, @Value("${libretranslate.url}") String libreTranslateUrl) {
            this.restTemplate = restTemplate;
            this.libreTranslateUrl = libreTranslateUrl;
        }

        public String translateText(String text, String sourceLanguage, String targetLanguage) {
            String url = libreTranslateUrl + "/translate";
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");

            Map<String, String> requestBody = new HashMap<>();
            requestBody.put("q", text);
            requestBody.put("source", sourceLanguage); // Assuming source language is English
            requestBody.put("target", targetLanguage);

            HttpEntity<Map<String, String>> request = new HttpEntity<>(requestBody, headers);
            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, request, Map.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                Map<String, String> responseBody = response.getBody();
                return responseBody != null ? responseBody.get("translatedText") : text;
            }

            return text; // Fallback to original text in case of an error
        }
    }
