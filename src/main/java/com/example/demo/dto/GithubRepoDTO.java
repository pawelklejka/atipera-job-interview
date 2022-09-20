package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record GithubRepoDTO(@NotBlank boolean fork,
                            @NotBlank @JsonProperty("full_name") String name,
                            @NotBlank @JsonProperty("branches_url") String url) {

}
