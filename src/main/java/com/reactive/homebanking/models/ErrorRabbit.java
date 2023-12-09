package com.reactive.homebanking.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ErrorQueue")
public class ErrorRabbit {

    @Id
    private String id;
   private String error;

    public ErrorRabbit() {
    }

    public ErrorRabbit(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
