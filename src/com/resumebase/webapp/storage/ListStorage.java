package com.resumebase.webapp.storage;

import com.resumebase.webapp.exception.ExistStorageException;
import com.resumebase.webapp.exception.NotExistStorageException;
import com.resumebase.webapp.exception.StorageException;
import com.resumebase.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListStorage extends AbstractStorage {

    public List<Resume> storage = new ArrayList<>();

    public void clear() {
       storage.clear();
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return null;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return false;
    }

    public void doUpdate(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
            //System.out.println("Resume {" + r.getUuid() + "} does not present in a storage and can not be updated");
        } else {
            storage.add(index, r);
            System.out.println("Resume {" + r.getUuid() + "} is updated");
        }
    }

    public void doSave(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(r.getUuid());
            //System.out.println("Resume {" + r.getUuid() + "} does present in a storage and can not be added");
        } else {
            storage.add(r);
            System.out.println("Resume {" + r.getUuid() + "} is saved");
        }
    }

    public void doDelete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
            //System.out.println("Resume with {" + uuid + "} does not present in a storage");
        } else {
            storage.remove(index);
            System.out.println("Resume with {" + uuid + "} is deleted");
        }
    }

    public List<Resume> getAll() {
        return storage;
    }

    public Resume doGet(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
            //System.out.println("Resume with {" + uuid + "} does not present in a storage");
            //return null;
        }
        return storage.get(index);
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (uuid.equals(storage.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
