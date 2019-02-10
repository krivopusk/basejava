package com.resumebase.webapp.storage;

import com.resumebase.webapp.model.Resume;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//TODO implements, create new MapResumeStorage with another search key type (not uuid)
public class MapUuidStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return null;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return false;
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {

    }

    @Override
    protected void doSave(Resume r, Object searchKey) {

    }

    @Override
    protected void doDelete(Object searchKey) {

    }

    @Override
    protected Resume doGet(Object searchKey) {
        return null;
    }


    @Override
    public void clear() {

    }

    @Override
    public List<Resume> doCopyAll() {
        return Collections.emptyList();
    }

    @Override
    public int size() {
        return 0;
    }
}
