package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Branch(String name,
                     String lastCommitSha) {

}
