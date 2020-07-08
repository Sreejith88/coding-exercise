package com.telstra.codechallenge.gitapicheck;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ApiResponse {

    private String total_count;
    private String incomplete_results;
    private List<Items> items;
}
