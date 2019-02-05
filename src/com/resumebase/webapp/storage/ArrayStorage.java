package com.resumebase.webapp.storage;

import com.resumebase.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertResume(Resume r, int index) {
        storage[realSize] = r;
    }

    @Override
    protected void fillDeletedElement(int index) {
        storage[index] = storage[realSize - 1];
    }

    //TODO check if resume present and return it's index
    protected int getIndex(String uuid) {
        for (int i = 0; i < realSize; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
