import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class IdGenerateServiceTest {

    class Random6 extends Random {
        @Override
        public int nextInt(int bound) {
            return 6;
        }
    }

    @Test
    public void getData() {
        Random stub = new Random6(); // Dependency
        // Dependency Injection (DI)
        // 1. Constructor Injection
        IdGenerateService service = new IdGenerateService();
        // 2. Setter/field/property Injection
        service.setRandom(stub);
        // 3. Method Injection
        String result = service.getData();
        assertEquals("CODE6", result);
    }
}