package com.letcode.SecureBankSystem.repository;

import com.letcode.SecureBankSystem.entity.GuestSuggestionEntity;
import com.letcode.SecureBankSystem.util.enums.SuggestionsStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestSuggestionRepository extends JpaRepository<GuestSuggestionEntity,Long> {
    List<GuestSuggestionEntity> findBySuggestionsStatus(SuggestionsStatus status);

}
