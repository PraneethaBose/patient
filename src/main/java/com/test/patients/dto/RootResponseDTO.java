package com.test.patients.dto;

import java.io.Serializable;

public class RootResponseDTO implements Serializable{
    private final boolean success;
    private final Serializable body;

    public RootResponseDTO(boolean success, Serializable body) {
        this.success = success;
        this.body = body;
    }

    public boolean isSuccess() {
        return success;
    }

    public Serializable getBody() {
        return body;
    }
}
