package com.example.GANGAMES.DTO;

import lombok.Data;

@Data
public class ErrorCustomResponse {
    private String message;

    public ErrorCustomResponse(String message) {
        this.message = message;
    }
}
