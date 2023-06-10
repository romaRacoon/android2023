package com.example.recipefoodapp.listener;

import com.example.recipefoodapp.model.InstructionsResponse;

import java.util.List;

public interface InstructionsListener {
    void didFetch(List<InstructionsResponse> response, String message);
    void didError(String message);
}
