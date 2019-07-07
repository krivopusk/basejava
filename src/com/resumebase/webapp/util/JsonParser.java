package com.resumebase.webapp.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.resumebase.webapp.model.Section;

import java.io.Writer;
import java.io.Reader;

public class JsonParser {
    private static Gson GSON = new GsonBuilder()
            .registerTypeAdapter(Section.class, new JsonSectionAdapter())
            .create();

    public static <T> T read(Reader reader, Class<T> clazz) {return GSON.fromJson(reader,clazz); }

    public static <T> void write(T object, Writer writer){ GSON.toJson(object, writer);}
}
