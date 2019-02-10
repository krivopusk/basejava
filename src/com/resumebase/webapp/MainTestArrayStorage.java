package com.resumebase.webapp;

import com.resumebase.webapp.model.Resume;
import com.resumebase.webapp.storage.ArrayStorage;
import com.resumebase.webapp.storage.Storage;

/**
 * Test for your com.resumebase.webapp.storage.ArrayStorage implementation
 */
public class   MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        final Resume r1 = new Resume("uuid1", "Name1");
        //r1.setUuid("uuid1");
        final Resume r2 = new Resume("uuid2","Name2" );
        //r2.setUuid("uuid2");
        final Resume r3 = new Resume("uuid3", "Name3");
        //r3.setUuid("uuid3");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        //System.out.println("Index of r3: " + Arrays.binarySearch(ARRAY_STORAGE.storage, 0, ARRAY_STORAGE.size(), r3));

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.update(r3);
        printAll();
        ARRAY_STORAGE.clear();
        printAll();


        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}
