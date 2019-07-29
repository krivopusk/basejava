package com.resumebase.webapp.util;

import com.resumebase.webapp.model.Resume;
import com.resumebase.webapp.model.Section;
import com.resumebase.webapp.model.TextSection;

import static com.resumebase.webapp.TestData.R1;
import org.junit.Assert;
import org.junit.Test;

public class JsonParserTest {

    @Test
    public void testResume() throws Exception {
        String json = JsonParser.write(R1);
        System.out.println(json);
        Resume resume = JsonParser.read(json, Resume.class);
        Assert.assertEquals(R1, resume);
    }

    @Test
    public void write() throws Exception {
        Section section1 = new TextSection("Objective1");
        String json = JsonParser.write(section1, Section.class);
        System.out.println(json);
        Section section2 = JsonParser.read(json, Section.class);
        Assert.assertEquals(section1, section2);
    }
}
