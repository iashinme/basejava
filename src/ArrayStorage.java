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
        if(this.size() == storage.length) {
            System.out.println("Array storage is full");
            return;
        }

        if(resume.uuid == null) {
            System.out.println("uuid is not be null");
            return;
        }

        if (this.get(resume.uuid) != null) {
            System.out.println("Resume with uuid equals " + resume.uuid + " is already exists");
            return;
        }

        for (int i = 0; i < storage.length; i++) {
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
        if(uuid == null) {
            System.out.println("uuid is not be null");
            return;
        }

        int sizeStorage = this.size();
        int remoteIterator = -1;
        for (int i = 0; i < sizeStorage; i++) {
            if (storage[i].uuid.equals(uuid)) {
                remoteIterator = i;
                break;
            }
        }

        if (remoteIterator == -1) {
            System.out.println("uuid is not found");
            return;
        }

        if (remoteIterator == storage.length - 1) {
            storage[remoteIterator] = null;
        } else {
            for (int i = remoteIterator; i < sizeStorage - 1; i++) {
                storage[i] = storage[i + 1];
            }
            storage[sizeStorage - 1] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int sizeStorage = this.size();
        Resume[] storageNotNull = new Resume[sizeStorage];
        for (int i = 0; i < sizeStorage; i++) {
            storageNotNull[i] = storage[i];
        }
        return storageNotNull;
    }

    int size() {
        int size = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                size++;
            }
        }
        return size;
    }
}
