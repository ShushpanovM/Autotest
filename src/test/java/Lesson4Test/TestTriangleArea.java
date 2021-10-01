package Lesson4Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static Lesson4.TriangleArea.triangleCheck;

public class TestTriangleArea {
    private static Logger logger = LoggerFactory.getLogger(TestTriangleArea.class);
    @BeforeAll
    static void beforeAll() {
        logger.trace("Метод выполнился перед всеми тестами");
        logger.error("Метод выполнился перед всеми тестами");
        logger.info("Метод выполнился перед всеми тестами");
        logger.debug("Метод выполнился перед всеми тестами");
    }
    @Test
    void testTriangleCheckIsTrue() {
        Assertions.assertTrue(triangleCheck(3, 4, 5));
    }
    @Test
    void testTriangleCheckIsFalse() {
        Assertions.assertFalse(triangleCheck(0, 4, 5));
    }
    @Test
    void testTriangleCheckIsOneSideNegative() {
        Assertions.assertFalse(triangleCheck(-1, 4, 5));
    }
    @Test
    void testTriangleCheckIsAllSideNegative() {
        Assertions.assertFalse(triangleCheck(-1, -2, -3));
    }
}
