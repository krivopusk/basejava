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
        if (isResumePresent(r.getUuid()) != null) {
            for (int i = 0; i < realSize; i++) {
                if (storage[i] == r) {
                    System.out.println("Resume {" + r.getUuid() + "} is updated");
                    storage[i].setUuid((storage[realSize - 1].getUuid()) + 1);
                    System.out.println("New uuid value is {" + r.getUuid() + "}");
                    return;
                }
            }
        }
        System.out.println("Resume is not present and can not be updated");
    }

    public void save(Resume r) {
        if (realSize == 10000) {
            System.out.println("ArrayStorage is full. You can not add a new resume");
            return;
        }
        if (isResumePresent(r.getUuid()) != null) {
            System.out.println("Resume {" + r.getUuid() + "} is can not be add. The resume presents in a storage");
            return;
        }
        storage[realSize] = r;
        realSize++;
        System.out.println("Resume {" + r.getUuid() + "} is saved");
    }


    public Resume get(String uuid) {
        return isResumePresent(uuid);
    }

    public void delete(String uuid) {
        if (isResumePresent(uuid) != null) {
            for (int i = 0; i < realSize; i++) {
                if (uuid == storage[i].getUuid()) {
                    storage[i] = storage[realSize - 1];
                    storage[realSize - 1] = null;
                    realSize--;
                    System.out.println("Resume {" + storage[i].getUuid() + "} is deleted");
                    return;
                }
            }
        }
        System.out.println("Resume is not present and can not be deleted");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, realSize);
    }

    public int size() {
        return realSize;
    }

    //TODO check if resume present
    private Resume isResumePresent(String uuid) {
        for (int i = 0; i < realSize; i++) {
            if (uuid == storage[i].getUuid()) {
                return storage[i];
            }
        }
        return null;
    }
}
