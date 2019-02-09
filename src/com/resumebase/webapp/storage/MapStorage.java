package com.resumebase.webapp.storage;

import com.resumebase.webapp.model.Resume;

public class MapStorage extends AbstractStorage {


    @Override
    protected Object getSearchKey(String uuid) {
        return null;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return false;
    }

    @Override
    protected void doUpdate(Resume r) {

    }

    @Override
    protected void doSave(Resume r) {

    }

    @Override
    protected Resume doGet(String uuid) {
        return null;
    }

    @Override
    protected void doDelete(String uuid) {

    }

    @Override
    public void clear() {

    }
}
