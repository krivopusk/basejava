package com.resumebase.webapp.storage;

import com.resumebase.webapp.exception.NotExistStorageException;
import com.resumebase.webapp.exception.StorageException;
import com.resumebase.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

/*
логика реализации теста на переполнение массива (StorageException):
        заполняем массив, но не вызываем у него переполнение
        если исключение вылетит раньше, чем массив будет заполнен,
        то тест должен провалиться (см. Assert.fail())
        если исключение вылетает, когда пытаемся добавить в полностью заполненный массив еще одно резюме
        - тест пройден
        добавьте конструктор в AbstractArrayStorageTest, который инициализирует Storage storage,
        а в наследниках добавьте конструкторы, которые будут вызывать super() с нужным хранилищем*/

public abstract class AbstractArrayStorageTest {

    private Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }


    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        Resume r = new Resume("uuid4");
        storage.save(r);
        storage.update(r);
        Assert.assertEquals(storage.get("uuid4"), storage.getAll()[3]);
    }

    @Test
    public void save() throws Exception {
        storage.save(new Resume("uuid4"));
        Assert.assertEquals(4, storage.size());

    }

    @Test
    public void delete() throws Exception {
        storage.delete("uuid1");
        for (int i = 0; i < storage.size(); i++) {
        Assert.assertNotSame("uuid1", storage.getAll()[i].getUuid());
        }
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void storageOverflow() throws Exception {
        for (int i =3; i< AbstractArrayStorage.STORAGE_LIMIT; i++) {
            try {
                storage.save(new Resume());
            }
            catch (StorageException e) {
                Assert.fail();
            }
        }
        try {
            storage.save(new Resume());
        }
        catch (StorageException e) {
            System.out.println("Test passed");
        }
    }

    @Test
    public void getAll() throws Exception {
        for (int i =0; i< storage.size(); i++) {
            Assert.assertEquals(storage.getAll()[i], storage.get("uuid" + (i+1)));
        }
    }

    @Test
    public void get() throws Exception {
        for (int i =0; i< storage.size(); i++) {
            Assert.assertEquals(storage.getAll()[i], storage.get("uuid" + (i+1)));
        }
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }
}