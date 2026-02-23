import java.util.*;

public class FakeDbRepository implements StudentRepository {
    private final FakeDb db;

    public FakeDbRepository(FakeDb db) {
        this.db = db;
    }

    public void save(StudentRecord rec) {
        db.save(rec);
    }

    public int count() {
        return db.count();
    }

    public List<StudentRecord> findAll() {
        return db.all();
    }
}