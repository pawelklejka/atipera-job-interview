package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record GithubRepo(@NotBlank String name,
                         @NotBlank String ownerName,
                         @NotBlank List<Branch> branches){


}
