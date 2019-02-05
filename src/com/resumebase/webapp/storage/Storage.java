package com.resumebase.webapp.storage;

import com.resumebase.webapp.model.Resume;

public interface Storage {

    void clear();

    void update(Resume r);

    void save(Resume r);

    Resume get(String uuid);

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll();

    void delete(String uuid);

    int size();

}
