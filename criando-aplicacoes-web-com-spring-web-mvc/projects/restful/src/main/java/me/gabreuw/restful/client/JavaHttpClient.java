package me.gabreuw.restful.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.gabreuw.restful.client.response.GithubResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class JavaHttpClient {

    private static final String URL = "https://api.github.com/users/ImGabreuw";

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public JavaHttpClient(ObjectMapper objectMapper) {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = objectMapper;
    }

    public GithubResponse fetchGithubUserInfo() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> responseFromGithubApi = sendRequest(request);

        GithubResponse githubUserInfo = null;

        try {
            githubUserInfo = objectMapper.readValue(responseFromGithubApi.body(), GithubResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return githubUserInfo;
    }

    private HttpResponse<String> sendRequest(HttpRequest request) {
        HttpResponse<String> response = null;

        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return response;
    }

}
