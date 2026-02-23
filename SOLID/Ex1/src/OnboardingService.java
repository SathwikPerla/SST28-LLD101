import java.util.*;

public class OnboardingService {

    private final StudentRepository repo;
    private final InputParser parser = new InputParser();
    private final StudentValidator validator = new StudentValidator();
    private final OutputPrinter printer = new OutputPrinter();

    public OnboardingService(StudentRepository repo) {
        this.repo = repo;
    }

    public void registerFromRawInput(String raw) {

        printer.printInput(raw);

        ParsedStudent data = parser.parse(raw);

        List<String> errors = validator.validate(data);

        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(repo.count());

        StudentRecord rec = new StudentRecord(
                id,
                data.name,
                data.email,
                data.phone,
                data.program);

        repo.save(rec);

        printer.printSuccess(id, repo.count(), rec);
    }
}