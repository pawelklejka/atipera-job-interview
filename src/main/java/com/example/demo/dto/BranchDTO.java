package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record BranchDTO(String name,
                        Commit commit) {

    public record Commit(String sha){
        
    }
}
