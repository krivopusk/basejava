package com.resumebase.webapp.model;

public enum ContactType {
    PHONE("Phone"),
    MOBILE("Mobile phone"),
    HOMEPHONE("Home phone"),
    SKYPE("Skype"),
    MAIL("Mail"),
    LINKEDIN("LinkedIn profile"),
    GITHUB("GitHub profile"),
    STACKOVERFLOW("StackOverflow profile"),
    HOMEPAGE("Home page");

    private String title;

    ContactType() {
    }

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
