package com.letcode.SecureBankSystem.service.suggestion;

import com.letcode.SecureBankSystem.bo.suggestion.CreateSuggestionRequest;

public interface ProcessSuggestion {
    void processSuggestion(CreateSuggestionRequest suggestionTex);
}