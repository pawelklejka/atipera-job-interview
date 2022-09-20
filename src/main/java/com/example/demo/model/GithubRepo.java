package com.example.demo.model;

import com.example.demo.dto.BranchDTO;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record GithubRepo(@NotBlank String name,
                         @NotBlank String ownerName,
                         @NotBlank List<BranchDTO> branches){


}
