package com.resumebase.webapp.storage;

import com.resumebase.webapp.exception.ExistStorageException;
import com.resumebase.webapp.exception.NotExistStorageException;
import com.resumebase.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract void doUpdate(Resume r, Object searchKey);
    protected abstract void doSave(Resume r, Object searchKey);
    protected abstract void doDelete(Object searchKey);
    protected abstract Resume doGet(Object searchKey);
    protected abstract boolean isExist(Object searchKey);
    protected abstract Object getSearchKey(String uuid);


    public void update(Resume r) {
        Object searchKey = getExistedKey(r.getUuid());
        doUpdate(r, searchKey);
        System.out.println("Resume {" + r.getUuid() + "} is updated");
    }

    public void save(Resume r) {
        Object searchKey = getNotExistedKey(r.getUuid());
        doSave(r, searchKey);
        System.out.println("Resume {" + r.getUuid() + "} is saved");

    }

    public void delete(String uuid) {
        Object searchKey = getExistedKey(uuid);
        doDelete(searchKey);
        System.out.println("Resume with {" + uuid + "} is deleted");

    }

    public Resume get(String uuid) {
        Object searchKey = getExistedKey(uuid);
        return doGet(searchKey);
    }

    private Object getExistedKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistedKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

}
