package com.resumebase.webapp.storage;

import com.resumebase.webapp.exception.ExistStorageException;
import com.resumebase.webapp.exception.NotExistStorageException;
import com.resumebase.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract SK getSearchKey(String uuid);

    protected abstract boolean isExist(SK searchKey);

    protected abstract void doUpdate(Resume r, SK searchKey);

    protected abstract void doSave(Resume r, SK searchKey);

    protected abstract void doDelete(SK searchKey);

    protected abstract Resume doGet(SK searchKey);

    protected abstract List<Resume> doCopyAll();

    public void update(Resume r) {
        LOG.info("Update " + r);
        SK searchKey = getExistedKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    public void save(Resume r) {
        LOG.info("Save " + r);
        SK searchKey = getNotExistedKey(r.getUuid());
        doSave(r, searchKey);

    }

    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK searchKey = getExistedKey(uuid);
        doDelete(searchKey);
    }

    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK searchKey = getExistedKey(uuid);
        return doGet(searchKey);
    }

    private SK getExistedKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistedKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("Get all sorted");
        List<Resume> list = doCopyAll();
        Collections.sort(list);
        return list;
    }

}
