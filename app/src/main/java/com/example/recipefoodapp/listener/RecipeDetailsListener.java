package com.example.recipefoodapp.listener;

import com.example.recipefoodapp.model.RecipeDetailsResponse;

public interface RecipeDetailsListener {
    void didFetch(RecipeDetailsResponse response, String message);
    void didError(String message);
}
