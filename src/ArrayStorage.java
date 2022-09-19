/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int sizeStorage = this.size();
        for (int i = 0; i < sizeStorage; i++) {
            storage[i] = null;
        }
    }

    void save(Resume resume) {
        if (this.get(resume.uuid) != null) {
            System.out.println("Resume with uuid equals " + resume.uuid + " is already exists");
            return;
        }

        for (int i = 0; i < 10000; i++) {
            if (storage[i] == null) {
                storage[i] = resume;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < this.size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int sizeStorage = this.size();
        int remoteIterator = -1;
        for (int i = 0; i < sizeStorage; i++) {
            if (storage[i].uuid.equals(uuid)) {
                remoteIterator = i;
                break;
            }
        }

        System.out.println(storage.length);
        if (remoteIterator == -1) {
            return;
        }

        if (remoteIterator == storage.length - 1) {
            storage[remoteIterator] = null;
        } else {
            for (int i = remoteIterator; i < sizeStorage; i++) {
                storage[i] = storage[i + 1];
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int sizeStorage = this.size();
        Resume[] storageNotNull = new Resume[sizeStorage];
        for (int i = 0; i < sizeStorage; i++) {
            if (storage[i] != null)
                storageNotNull[i] = storage[i];
        }
        return storageNotNull;
    }

    int size() {
        int size = 0;
        for (int i = 0; i < 10000; i++) {
            if (storage[i] != null) {
                size++;
            }
        }
        return size;
    }
}
