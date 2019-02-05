package com.resumebase.webapp.storage;

import com.resumebase.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertResume(Resume r, int index) {
        int insertIdx = -index - 1;
        System.arraycopy(storage, insertIdx, storage, index + 1, realSize - insertIdx);
        storage[insertIdx] = r;
    }


    @Override
    protected void fillDeletedElement(int index) {
        int numMoved = realSize - index - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, index - 1, storage, index, numMoved);
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, realSize, searchKey);
    }
}
