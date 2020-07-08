package com.telstra.codechallenge.gitapicheck;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GitApiCheckService {

    @Value("${git.base.url}")
    private String gitBaseUrl;
    private String PATH_URL = "/search/users?q={q}&sort={sort}&order={order}&per_page={per_page}";

    private RestTemplate restTemplate;

    public GitApiCheckService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * <p>
     *     To get old users Account in Github by using Github Search API.
     * </p>
     * @param limit the number of items to be returned.
     * @return list of {@link Items} instance.
     */
    public List<Items> getOldUserAccounts(final String limit) {

        Map<String,Object> params = new HashMap<>();
        params.put("q", "followers:0");
        params.put("sort", "joined");
        params.put("order", "asc");
        params.put("per_page", Integer.valueOf(limit));

        final ApiResponse apiResponse = restTemplate.getForObject(gitBaseUrl + PATH_URL, ApiResponse.class, params);
        return apiResponse.getItems();

    }
}
