package com.telstra.codechallenge.gitapicheck;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Items {

    private String id;
    private String login;
    private String html_url;
}
