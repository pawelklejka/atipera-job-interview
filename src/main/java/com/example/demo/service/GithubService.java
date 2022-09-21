package com.example.demo.service;

import com.example.demo.model.Branch;
import com.example.demo.model.GithubRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GithubService {
    private final GithubClient githubClient;

    public GithubService(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    public Optional<List<GithubRepo>> findAll(String userName){

        List<GithubRepo> githubRepos = githubClient.getGithubRepos(userName).stream()
                .filter(r -> !r.fork())
                .map(r -> {
                    //we get full name in a form of "username/repo"
                    String[] ownerAndReponame = r.name().split("/");
                    List<Branch> branches  = githubClient.getBranches(ownerAndReponame[0], ownerAndReponame[1]);

                    return new GithubRepo(ownerAndReponame[1], ownerAndReponame[0], branches);
                })
                .collect(Collectors.toList());
        return Optional.of(githubRepos);
    }

}
