import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int realSize = 0;

    void clear() {
        for (int i = 0; i < realSize; i++) {
            storage[i] = null;
        }
        realSize = 0;
    }

    void save(Resume r) {
        if (size() == 10000) {
            System.out.println("ArrayStorage is full. You can not add a new resume");
            return;
        }
        storage[realSize] = r;
        realSize++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < realSize; i++) {
            if ((storage[i].uuid).equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < realSize; i++) {
            if (uuid.equals(storage[i].uuid)) {
                //the element at the end of the array replaces the element which we want to remove
                storage[i] = storage[realSize - 1];
                storage[realSize - 1] = null;
                realSize--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, realSize);
    }

    int size() {
        return realSize;
    }
}
