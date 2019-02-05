package com.resumebase.webapp.storage;

import com.resumebase.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int realSize = 0;


    public int size() {
        return realSize;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume with {" + uuid + "} does not present in a storage");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);

}
