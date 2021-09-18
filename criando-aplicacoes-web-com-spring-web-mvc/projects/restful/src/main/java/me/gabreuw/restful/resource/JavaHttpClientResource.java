package me.gabreuw.restful.resource;

import lombok.RequiredArgsConstructor;
import me.gabreuw.restful.client.response.GithubResponse;
import me.gabreuw.restful.service.JavaHttpClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/java-http-client")
@RequiredArgsConstructor
public class JavaHttpClientResource {

    private final JavaHttpClientService javaHttpClientService;

    @GetMapping
    public ResponseEntity<GithubResponse> sendRequestToGitHubAPI() {
        return ResponseEntity
                .ok()
                .body(javaHttpClientService.sendRequestToGitHubAPI());
    }

}
