package com.letcode.SecureBankSystem.service.suggestion;

import com.letcode.SecureBankSystem.entity.GuestSuggestionEntity;

import java.util.List;

public interface SuggestionService {
    void getSuggestionRate ();
    List<GuestSuggestionEntity> getCreateStatusSuggestions();
    List<GuestSuggestionEntity> getRemoveStatusSuggestions();

}