package com.resumebase.webapp.storage;

import com.resumebase.webapp.model.Resume;

import java.util.List;

//TODO refactor implement getAllSorted
public interface Storage {

    void clear();

    void update(Resume r);

    void save(Resume r);

    Resume get(String uuid);

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    List<Resume> getAllSorted();

// Resume[] getAll();

    void delete(String uuid);

    int size();


}
