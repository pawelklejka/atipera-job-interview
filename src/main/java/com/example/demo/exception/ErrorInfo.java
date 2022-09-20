package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public record ErrorInfo(String status,
                        String message) {

}