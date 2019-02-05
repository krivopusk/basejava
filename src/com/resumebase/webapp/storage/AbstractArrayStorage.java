package com.resumebase.webapp.storage;

import com.resumebase.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int realSize = 0;

    public void clear() {
        Arrays.fill(storage, 0, realSize, null);
        realSize = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            System.out.println("Resume {" + r.getUuid() + "} does not present in a storage and can not be updated");
        } else {
            storage[index] = r;
            System.out.println("Resume {" + r.getUuid() + "} is updated");
        }
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index > 0) {
            System.out.println("Resume {" + r.getUuid() + "} does present in a storage and can not be added");
        } else if (realSize == STORAGE_LIMIT) {
            System.out.println("ArrayStorage overflow");
        } else {
            insertResume(r, index);
            realSize++;
            System.out.println("Resume {" + r.getUuid() + "} is saved");
        }
    }

    protected abstract void insertResume(Resume r, int index);

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume with {" + uuid + "} does not present in a storage");
        } else {
            fillDeletedElement(index);
            storage[realSize - 1] = null;
            System.out.println("Resume with {" + uuid + "} is deleted");
            realSize--;
        }
    }

    protected abstract void fillDeletedElement(int index);

    public int size() {
        return realSize;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, realSize);
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume with {" + uuid + "} does not present in a storage");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);

}
