package com.example.demo.service;


import com.example.demo.dto.GithubRepoDTO;
import com.example.demo.model.Branch;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient(name = "github-api", url = "https://api.github.com")
@Headers("Accept: application/json")
public interface GithubClient {

    @GetMapping("/users/{userName}/repos")
    List<GithubRepoDTO> getGithubRepos(@PathVariable("userName") String userName);

    @GetMapping("/repos/{userName}/{repoName}/branches")
    List<Branch> getBranches(@PathVariable("userName") String userName, @PathVariable("repoName") String repoName);
}
