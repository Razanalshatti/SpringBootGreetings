package com.letcode.SecureBankSystem.controller.suggestion;


import com.letcode.SecureBankSystem.bo.suggestion.CreateSuggestionRequest;
import com.letcode.SecureBankSystem.entity.GuestSuggestionEntity;
import com.letcode.SecureBankSystem.service.suggestion.GuestSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/guest")
public class SuggestionController {

    private final GuestSuggestionService suggestionService;

    public SuggestionController(GuestSuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @PostMapping("/suggest")
    public ResponseEntity<List<GuestSuggestionEntity>> handleSuggestions(@RequestBody CreateSuggestionRequest suggestionRequest) {
        List<GuestSuggestionEntity> suggestionList = suggestionService.printAndProcessSuggestion(suggestionRequest.getSuggestionText());
        return ResponseEntity.ok(suggestionList);
    }
    @PostMapping("/create-suggestion")
    public ResponseEntity<String> processSuggestion(CreateSuggestionRequest suggestionTex){
        suggestionService.processSuggestion(suggestionTex);
        return ResponseEntity.ok(" you create a suggestion");
    }
}
