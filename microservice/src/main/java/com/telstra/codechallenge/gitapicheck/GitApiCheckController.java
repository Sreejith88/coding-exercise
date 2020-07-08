package com.telstra.codechallenge.gitapicheck;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GitApiCheckController {

    private GitApiCheckService gitApiCheckService;

    public GitApiCheckController(GitApiCheckService gitApiCheckService) {
        this.gitApiCheckService = gitApiCheckService;
    }

    /**
     * <p>
     *     To get old users Account in Github by using Github Search API.
     * </p>
     * @param limit the number of items to be returned.
     * @return list of {@link Items} instance.
     */
    @RequestMapping(path = "/old-users-account", method = RequestMethod.GET)
    public List<Items> getOldUserAccounts(@RequestParam(value = "limit", defaultValue = "1") String limit) {
        return gitApiCheckService.getOldUserAccounts(limit);
    }
}
