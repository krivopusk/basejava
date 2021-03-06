package com.resumebase.webapp;

import com.resumebase.webapp.model.*;

import java.time.Month;
import java.util.UUID;

public class TestData {
    public static final String UUID_1 = UUID.randomUUID().toString();
    public static final String UUID_2 = UUID.randomUUID().toString();
    public static final String UUID_3 = UUID.randomUUID().toString();
    public static final String UUID_4 = UUID.randomUUID().toString();

    public static final Resume R1;
    public static final Resume R2;
    public static final Resume R3;
    public static final Resume R4;

    static {
        R1 = new Resume(UUID_1, "Name1");
        R2 = new Resume(UUID_2, "Name2");
        R3 = new Resume(UUID_3, "Name3");
        R4 = new Resume(UUID_4, "Name4");

        R1.addContact(ContactType.MAIL, "mail1@ya.ru");
        R1.addContact(ContactType.PHONE, "11111");

        R4.addContact(ContactType.PHONE, "44444");
        R4.addContact(ContactType.SKYPE, "Skype");

        R1.addSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        R1.addSection(SectionType.PERSONALITY, new TextSection("Personal data"));
        R1.addSection(SectionType.ACHIEVEMENTS, new ListSection("Achivment11", "Achivment12", "Achivment13"));
        R1.addSection(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "JavaScript"));
        R1.addSection(SectionType.EXPERIENCE,
                new OrganisationSection(
                        new Organisation("Organization11", "http://Organization11.ru",
                                new Organisation.Position(2005, Month.JANUARY, "position1", "content1"),
                                new Organisation.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        R1.addSection(SectionType.EXPERIENCE,
                new OrganisationSection(
                        new Organisation("Organization2", "http://Organization2.ru",
                                new Organisation.Position(2015, Month.JANUARY, "position1", "content1"))));
        R1.addSection(SectionType.EDUCATION,
                new OrganisationSection(
                        new Organisation("Institute", null,
                                new Organisation.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null),
                                new Organisation.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organisation("Organization12", "http://Organization12.ru")));

        R2.addContact(ContactType.SKYPE, "skype2");
        R2.addContact(ContactType.PHONE, "22222");
    }
}
