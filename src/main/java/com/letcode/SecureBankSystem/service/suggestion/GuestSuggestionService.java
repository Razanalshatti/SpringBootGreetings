package com.letcode.SecureBankSystem.service.suggestion;


import com.letcode.SecureBankSystem.bo.suggestion.CreateSuggestionRequest;
import com.letcode.SecureBankSystem.entity.GuestSuggestionEntity;
import com.letcode.SecureBankSystem.repository.GuestSuggestionRepository;
import com.letcode.SecureBankSystem.util.enums.SuggestionsStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class GuestSuggestionService implements SuggestionService {

    private final GuestSuggestionRepository suggestionRepository ;

    public GuestSuggestionService(GuestSuggestionRepository suggestionRepository) {
        this.suggestionRepository = suggestionRepository;
    }





    public List<GuestSuggestionEntity> findAllDataSuggestions() {
        List<GuestSuggestionEntity> allSuggestions = suggestionRepository.findAll();
        return allSuggestions.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public List<GuestSuggestionEntity> printAndProcessSuggestion(String suggestionText) {
        return suggestionRepository.findAll();

    }
    public List<GuestSuggestionEntity> findAllCreatedSuggestions(){
        return suggestionRepository.findBySuggestionsStatus(SuggestionsStatus.CREATE);
    }
    public List<GuestSuggestionEntity> findAllRemovedSuggestions(){
        return suggestionRepository.findBySuggestionsStatus(SuggestionsStatus.REMOVE);
    }

//    @Override
//    public void processSuggestion(CreateSuggestionRequest suggestionTex) {
//      SuggestionService processSuggestion = suggestionText -> {
//
//            GuestSuggestionEntity suggestionEntity = new GuestSuggestionEntity();
//            suggestionEntity.setSuggestionText(suggestionTex.getSuggestionText());
//
//            suggestionRepository.save(suggestionEntity);
//        };
//    }


    public void processSuggestion(CreateSuggestionRequest suggestionTex) {
        ProcessSuggestion processSuggestion = suggest -> {
            GuestSuggestionEntity suggestionEntity = new GuestSuggestionEntity();
            suggestionEntity.setSuggestionText(suggestionEntity.getSuggestionText());
            suggestionRepository.save(suggestionEntity);
        };
    }

    @Override
    public void getSuggestionRate() {


    }

    @Override
    public List<GuestSuggestionEntity> getCreateStatusSuggestions() {
        return suggestionRepository.findAll().stream()
                .filter(suggestion -> suggestion.getSuggestionsStatus().equals(SuggestionsStatus.CREATE))
                .collect(Collectors.toList());

    }

    @Override
    public List<GuestSuggestionEntity> getRemoveStatusSuggestions() {
        return suggestionRepository.findAll().stream()
                .filter(suggestion -> suggestion.getSuggestionsStatus().equals(SuggestionsStatus.REMOVE))
                .collect(Collectors.toList());

    }

    public void processAndSaveSuggestion(CreateSuggestionRequest suggestionRequest) {
    }
}