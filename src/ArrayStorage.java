import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                return;
            }
        }
    }

    Resume get(String uuid) {

        for (int i = 0; i < storage.length; i++) {
            if(storage[i]!=null && storage[i].uuid.equals(uuid)){
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if(storage[i]!=null && storage[i].uuid.equals(uuid)){
                for (int j = i; j < size(); j++) {
                    storage[j] = storage[j+1];
                };

            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result = new Resume[size()];
        for (int i = 0; i < storage.length; i++) {
            if(storage[i]!=null){
                result[i] = storage[i];
            }
        }
        return result;
    }

    int size() {

        int counter = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                counter++;
            }
        }
        return counter;

    }


}
