package com.letcode.SecureBankSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_setting")
public class UserSettingEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean recieveNewsLetter;

    private String preferredLanguage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isRecieveNewsLetter() {
        return recieveNewsLetter;
    }

    public void setRecieveNewsLetter(boolean recieveNewsLetter) {
        this.recieveNewsLetter = recieveNewsLetter;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
