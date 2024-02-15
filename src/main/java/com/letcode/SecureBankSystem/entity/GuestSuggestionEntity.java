package com.letcode.SecureBankSystem.entity;

import com.letcode.SecureBankSystem.util.enums.SuggestionsStatus;

import javax.persistence.*;

@Entity
@Table(name = "suggestions")
public class GuestSuggestionEntity {
    public GuestSuggestionEntity() {

    }

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rate",nullable = false)
    private String rate;
    @Column(name = "suggestion_text",nullable = false)
    private String suggestionText;
    @Enumerated(EnumType.STRING)
    @Column(name = "suggestion_status",nullable = false)
    private SuggestionsStatus suggestionsStatus;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getSuggestionText() {
        return suggestionText;
    }

    public void setSuggestionText(String suggestionText) {
        this.suggestionText = suggestionText;
    }

    public SuggestionsStatus getSuggestionsStatus() {
        return suggestionsStatus;
    }

    public void setSuggestionsStatus(SuggestionsStatus suggestionsStatus) {
        this.suggestionsStatus = suggestionsStatus;
    }
}