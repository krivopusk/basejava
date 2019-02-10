package com.resumebase.webapp.storage;

import com.resumebase.webapp.exception.StorageException;
import com.resumebase.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int realSize = 0;

    protected abstract void insertResume(Resume r, int index);

    protected abstract void fillDeletedElement(int index);

    @Override
    protected abstract Integer getSearchKey(String uuid);

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
    }

    public void clear() {
        Arrays.fill(storage, 0, realSize, null);
        realSize = 0;
    }

    @Override
    protected void doUpdate(Resume r, Object index) {
        storage[(Integer) index] = r;
    }

    @Override
    protected void doSave(Resume r, Object index) {
        if (realSize == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertResume(r, (Integer) index);
            realSize++;
        }
    }

    @Override
    protected void doDelete(Object index) {
        fillDeletedElement((Integer) index);
        storage[realSize - 1] = null;
        realSize--;
    }

    public int size() {
        return realSize;
    }

    @Override
    public List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, realSize));
    }

    public Resume doGet(Object index) {
        return storage[(Integer) index];
    }

}
