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

    @Test
    public void getData2() {
        SpyRandom spy = new SpyRandom(); // Dependency
        // Dependency Injection (DI)
        // 1. Constructor Injection
        IdGenerateService service = new IdGenerateService();
        // 2. Setter/field/property Injection
        service.setRandom(spy);
        service.getData();
        // Assert
        spy.verify(1);
    }

    class SpyRandom extends Random {
        private int count;

        @Override
        public int nextInt(int bound) {
            count++;
            return 6;
        }

        public void verify(int expectedCount) {
            assertTrue(count == expectedCount);
        }
    }
}