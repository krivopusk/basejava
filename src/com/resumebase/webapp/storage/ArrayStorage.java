package com.resumebase.webapp.storage;

import com.resumebase.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int realSize = 0;

    public void clear() {
        for (int i = 0; i < realSize; i++) {
            storage[i] = null;
        }
        realSize = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index != -1) {
            System.out.println("Resume {" + r.getUuid() + "} does present in a storage and can not be updated");
        } else {
            storage[index] = r;
            System.out.println("Resume {" + r.getUuid() + "} is updated");
        }
    }

    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("Resume {" + r.getUuid() + "} does present in a storage and can not be added");
        } else if (realSize == storage.length) {
            System.out.println("ArrayStorage overflow");
        } else {
            storage[realSize] = r;
            realSize++;
            System.out.println("Resume {" + r.getUuid() + "} is saved");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume with {" + uuid + "} does not present in a storage");
            return null;
        }
        return storage[index];
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, realSize);
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume with {" + uuid + "} does not present in a storage");
        } else {
            storage[index] = storage[realSize - 1];
            storage[realSize - 1] = null;
            System.out.println("Resume with {" + uuid + "} is deleted");
            realSize--;
        }
    }

    public int size() {
        return realSize;
    }


    //TODO check if resume present and return it's index
    private int getIndex(String uuid) {
        for (int i = 0; i < realSize; i++) {
            if (uuid == storage[i].getUuid()) {
                return i;
            }
        }
        return -1;
    }
}
