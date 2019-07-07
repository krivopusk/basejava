package com.resumebase.webapp.model;

public enum SectionType {
    PERSONALITY("Personality"),
    OBJECTIVE("Job objective"),
    ACHIEVEMENTS("Achievements"),
    QUALIFICATIONS("Qualifications"),
    EXPERIENCE("Experience"),
    EDUCATION("Education");

    private String title;

    SectionType() {
    }

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
