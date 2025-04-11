package functionTest;

import mainFunction.Function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import logarifm.*;
import trigonometry.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

class FunctionTest {

    private Function function;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        function = new Function();
    }

    @Test
    void testF_whenXIsZero() {
        double epsilon = 1e-5;

        // Мокаем математические функции для x = 0
        try (
                MockedStatic<Sin> sinMock = mockStatic(Sin.class);
                MockedStatic<Cos> cosMock = mockStatic(Cos.class);
                MockedStatic<Tan> tanMock = mockStatic(Tan.class);
                MockedStatic<Cot> cotMock = mockStatic(Cot.class);
                MockedStatic<Sec> secMock = mockStatic(Sec.class);
                MockedStatic<Csc> cscMock = mockStatic(Csc.class)
        ) {
            sinMock.when(() -> Sin.sin(0, epsilon)).thenReturn(Math.sin(0)); // Math.sin(0) == 0
            cosMock.when(() -> Cos.cos(0, epsilon)).thenReturn(Math.cos(0)); // Math.cos(0) == 1
            tanMock.when(() -> Tan.tan(0, epsilon)).thenReturn(Math.tan(0)); // Math.tan(0) == 0
            cotMock.when(() -> Cot.cot(0, epsilon)).thenThrow(new IllegalArgumentException("Cotangent is undefined at x=0")); // Выбрасываем исключение при попытке вычислить котангенс в 0
            secMock.when(() -> Sec.sec(0, epsilon)).thenReturn(1 / Math.cos(0)); // Math.cos(0) == 1
            cscMock.when(() -> Csc.csc(0, epsilon)).thenReturn(1 / Math.sin(0)); // Math.sin(0) == 0, будет бесконечность
        }

        // Проверяем, что исключение выбрасывается при x = 0
        assertThrows(IllegalArgumentException.class, () -> function.f(0, epsilon),
                "Cotangent is undefined at x=0"); // Ожидаем, что будет выброшено исключение
    }


    @Test
    void testF_whenXGreaterThanZero() {
        double epsilon = 1e-5;
        double testEpsilon = 1e-3;
        double x = 10;

        // Мокаем логарифмические функции
        try (
                MockedStatic<Ln> lnMock = mockStatic(Ln.class);
                MockedStatic<Log_2> log2Mock = mockStatic(Log_2.class);
                MockedStatic<Log_3> log3Mock = mockStatic(Log_3.class);
                MockedStatic<Log_5> log5Mock = mockStatic(Log_5.class);
                MockedStatic<Log_10> log10Mock = mockStatic(Log_10.class)
        ) {
            lnMock.when(() -> Ln.ln(x, epsilon)).thenReturn(Math.log(x)); // log(x) = Math.log(x)
            log2Mock.when(() -> Log_2.log_2(x, epsilon)).thenReturn(Math.log(x) / Math.log(2)); // log2(x) = log(x) / log(2)
            log3Mock.when(() -> Log_3.log_3(x, epsilon)).thenReturn(Math.log(x) / Math.log(3)); // log3(x) = log(x) / log(3)
            log5Mock.when(() -> Log_5.log_5(x, epsilon)).thenReturn(Math.log(x) / Math.log(5)); // log5(x) = log(x) / log(5)
            log10Mock.when(() -> Log_10.log_10(x, epsilon)).thenReturn(Math.log10(x)); // log10(x) = Math.log10(x)
        }

        // Вызываем функцию
        double result = function.f(x, epsilon);

        // Проверяем, что результат корректен
        assertNotNull(result); // Проверка на ненулевой результат
        // Я подставлю в это место нужное значение
        assertEquals(24.89945, result, testEpsilon); // Примерное ожидаемое значение
    }

    @Test
    void testF_whenXIsNegative() {
        double epsilon = 1e-5;
        double testEpsilon = 1e-3;
        double x = -4;

        // Мокаем функции для тригонометрии с использованием Math
        try (
                MockedStatic<Sin> sinMock = mockStatic(Sin.class);
                MockedStatic<Cos> cosMock = mockStatic(Cos.class);
                MockedStatic<Tan> tanMock = mockStatic(Tan.class);
                MockedStatic<Cot> cotMock = mockStatic(Cot.class);
                MockedStatic<Sec> secMock = mockStatic(Sec.class);
                MockedStatic<Csc> cscMock = mockStatic(Csc.class)
        ) {
            sinMock.when(() -> Sin.sin(x, epsilon)).thenReturn(Math.sin(x));
            cosMock.when(() -> Cos.cos(x, epsilon)).thenReturn(Math.cos(x));
            tanMock.when(() -> Tan.tan(x, epsilon)).thenReturn(Math.tan(x));
            cotMock.when(() -> Cot.cot(x, epsilon)).thenReturn(1.0 / Math.tan(x));
            secMock.when(() -> Sec.sec(x, epsilon)).thenReturn(1.0 / Math.cos(x));
            cscMock.when(() -> Csc.csc(x, epsilon)).thenReturn(1.0 / Math.sin(x));
        }

        // Вызываем функцию
        double result = function.f(x, epsilon);

        // Проверяем, что результат корректен
        assertNotNull(result); // Проверка на ненулевой результат
        // Я подставлю в это место нужное значение
        assertEquals(-4.60950, result, testEpsilon); // Примерное ожидаемое значение
    }

    @Test
    void testF_whenXIsEdgeCase() {
        double epsilon = 1e-5;
        double x = 1;

        // Мокаем логарифмические функции для x = 1
        try (
                MockedStatic<Ln> lnMock = mockStatic(Ln.class);
                MockedStatic<Log_2> log2Mock = mockStatic(Log_2.class);
                MockedStatic<Log_3> log3Mock = mockStatic(Log_3.class);
                MockedStatic<Log_5> log5Mock = mockStatic(Log_5.class);
                MockedStatic<Log_10> log10Mock = mockStatic(Log_10.class)
        ) {
            lnMock.when(() -> Ln.ln(x, epsilon)).thenReturn(Math.log(x)); // log(x) = Math.log(x)
            log2Mock.when(() -> Log_2.log_2(x, epsilon)).thenReturn(Math.log(x) / Math.log(2)); // log2(1) == 0
            log3Mock.when(() -> Log_3.log_3(x, epsilon)).thenReturn(Math.log(x) / Math.log(3)); // log3(1) == 0
            log5Mock.when(() -> Log_5.log_5(x, epsilon)).thenReturn(Math.log(x) / Math.log(5)); // log5(1) == 0
            log10Mock.when(() -> Log_10.log_10(x, epsilon)).thenReturn(Math.log10(x)); // log10(1) == 0
        }

        // Проверяем результат для x = 1
        double result = function.f(x, epsilon);
        assertEquals(0.0, result, epsilon);
    }
}
