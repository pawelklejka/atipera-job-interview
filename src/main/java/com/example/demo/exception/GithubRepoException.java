package com.example.demo.exception;

public class GithubRepoException extends RuntimeException{
    private GithubRepoError githubRepoError;

    public GithubRepoException(GithubRepoError githubRepoError){ this.githubRepoError = githubRepoError; }

    public GithubRepoError getGithubRepoError() {
        return githubRepoError;
    }
}
