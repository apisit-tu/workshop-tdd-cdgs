import java.util.Random;

public class IdGenerateService {

    Random random;

    public  String getData() {
        // Dependency
        int id = random.nextInt(10);
        // Result
        return "CODE" + id;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
