package com.example.demo.controller;

import com.example.demo.exception.GithubRepoError;
import com.example.demo.exception.GithubRepoException;
import com.example.demo.model.GithubRepo;
import com.example.demo.service.GithubService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/repos")
public class GithubController {
    private final GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/{userName}")
    public List<GithubRepo> findAll(@PathVariable("userName") String userName){
        return githubService.findAll(userName)
                .orElseThrow(() -> new GithubRepoException(GithubRepoError.USER_NOT_FOUND));
    }
}
