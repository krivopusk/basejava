package com.resumebase.webapp.storage;

import com.resumebase.webapp.model.Resume;

import java.util.List;

public interface Storage {

    void clear();

    void update(Resume r);

    void save(Resume r);

    Resume get(String uuid);

    /**
     * @return list, sorted by name
     */
    List<Resume> getAllSorted();

    /*
    @return array, contains only Resumes in storage (without null)
    Resume[] getAll();
    */

    void delete(String uuid);

    int size();


}
