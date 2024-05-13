package ru.example.WebNewsService.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.CompletableFuture;

@Service
public class JsonService {

    private final ObjectMapper mapper = new ObjectMapper();

    @Async
    public <T> CompletableFuture<String> toJSON(T object) {
        CompletableFuture<String> future = new CompletableFuture<>();

        try {
            String json = mapper.writeValueAsString(object);
            future.complete(json);
        } catch (JsonProcessingException e) {
            future.completeExceptionally(e);
        }

        return future;
    }

    @Async
    public <T> CompletableFuture<T> jsonToObject(String json, Class<T> classObject) {
        CompletableFuture<T> future = new CompletableFuture<>();

        try {
            T object = mapper.readValue(json, classObject);
            future.complete(object);
        } catch (JsonProcessingException e) {
            future.completeExceptionally(e);
        }

        return future;
    }
}
