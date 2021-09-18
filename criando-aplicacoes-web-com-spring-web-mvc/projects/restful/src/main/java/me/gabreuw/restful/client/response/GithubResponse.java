package me.gabreuw.restful.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GithubResponse implements Serializable {

    @JsonProperty("login")
    private String username;

    @JsonProperty("avatar_url")
    private String avatar;

    @JsonProperty("url")
    private String profile;

}
