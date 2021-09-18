package me.gabreuw.restful.service;

import lombok.RequiredArgsConstructor;
import me.gabreuw.restful.client.JavaHttpClient;
import me.gabreuw.restful.client.response.GithubResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JavaHttpClientService {

    private final JavaHttpClient httpClient;

    public GithubResponse sendRequestToGitHubAPI() {
        return httpClient.fetchGithubUserInfo();
    }

}
