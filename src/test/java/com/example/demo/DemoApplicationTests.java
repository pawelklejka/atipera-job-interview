package com.example.demo;

import com.example.demo.dto.BranchDTO;
import com.example.demo.dto.GithubRepoDTO;
import com.example.demo.model.Branch;
import com.example.demo.model.GithubRepo;
import com.example.demo.service.GithubClient;
import com.example.demo.service.GithubService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

    @InjectMocks
    GithubService githubService;

    @Mock
    GithubClient githubClient;

    @Test
    public void createGithubRepo(){
        GithubRepo githubRepo = new GithubRepo("repoName","ownerName", List.of(new BranchDTO("repoBranch", new BranchDTO.Commit("5ha5as5"))));

        String repoName = "repoName";
        String ownerName = "ownerName";
        List<BranchDTO> branchDTOS = List.of(new BranchDTO("repoBranch", new BranchDTO.Commit("5ha5as5")));

        Assertions.assertEquals(repoName, githubRepo.name());
        Assertions.assertEquals(ownerName, githubRepo.ownerName());
        Assertions.assertEquals(branchDTOS, githubRepo.branches());

    }
    @Test
    public void createGithubRepoDTO(){
        GithubRepoDTO githubRepo = new GithubRepoDTO(false,"username/repo", "somelink");

        boolean isFork = false;
        String repoName = "username/repo";
        String url = "somelink";


        Assertions.assertEquals(isFork, githubRepo.fork());
        Assertions.assertEquals(repoName, githubRepo.name());
        Assertions.assertEquals(url, githubRepo.url());

    }
    @Test
    public void testGithubServiceFindAll(){
        List<GithubRepoDTO> repos = List.of(new GithubRepoDTO(false,"username/repo", "somelink"));
        List<BranchDTO> branchDTOS = List.of(new BranchDTO("branch", new BranchDTO.Commit("5ha5as5")));

        Optional<List<GithubRepo>> githubRepos = Optional
                .of(List.of(new GithubRepo("repo","username",
                        List.of(new BranchDTO("branch", new BranchDTO.Commit("5ha5as5"))))));




        Mockito.when(githubClient.getGithubRepos("username"))
                .thenReturn(repos);

        Mockito.when(githubClient.getBranches("username", "repo"))
                        .thenReturn(branchDTOS);

//        Mockito.when(githubService.findAll("ownerName"))
//                .thenReturn(githubRepos);

        Optional<List<GithubRepo>> testRepo = githubService.findAll("username");


        Assertions.assertEquals(githubRepos, testRepo);

    }



    @Test
    void contextLoads() {
    }


}
