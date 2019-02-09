package com.resumebase.webapp.storage;

import com.resumebase.webapp.exception.ExistStorageException;
import com.resumebase.webapp.exception.NotExistStorageException;
import com.resumebase.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage<Key> implements Storage {

    protected abstract Key getSearchKey(String uuid);
    protected abstract boolean isExist(Key searchKey);
    protected abstract void doUpdate(Resume r);
    protected abstract void doSave(Resume r);
    protected abstract Resume doGet(String uuid);
    protected abstract void doDelete(String uuid);
    //protected abstract List<Resume> doCopyAll();

    public void update(Resume r) {
        doUpdate(r);
    }

    public void save(Resume r) {
        doSave(r);
    }

    public void delete(String uuid) {
        doDelete(uuid);
    }

    public Resume get(String uuid) {
        return doGet(uuid);
    }

    private Key getExistedSearchKey(String uuid) {
        Key searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            System.out.println("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Key getNotExistedSearchKey(String uuid) {
        Key searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            System.out.println("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    /*public List<Resume> getAllSorted() {
        System.out.println("getAllSorted");
        List<Resume> list = doCopyAll();
        Collections.sort(list);
        return list;
    }*/
}
