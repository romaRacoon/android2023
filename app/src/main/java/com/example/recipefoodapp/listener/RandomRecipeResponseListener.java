package com.example.recipefoodapp.listener;

import com.example.recipefoodapp.model.Root;

public interface RandomRecipeResponseListener {
    void didFetch(Root root, String message);
    void didError(String message);
}
