package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    public static void main(String[] args) {

        // Проверка базового функционала калькулятора с целыми числами:
        if (10 != Calculator.calculation(5, 5, '+')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (0 != Calculator.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка в методе");
        }
        if (14 != Calculator.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (2 != Calculator.calculation(100, 50, '/')) {
            throw new AssertionError("Ошибка в методе");
        }

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);


        // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
        assertThatThrownBy(() ->
                Calculator.calculation(8, 4, '_')
        ).isInstanceOf(IllegalStateException.class);


        // Проверка переполнения
        try {
            Calculator.calculation(Integer.MAX_VALUE, 1, '+');
            assert false; // Если мы здесь, значит, ожидаемого исключения не было
        } catch (ArithmeticException e) {
            assert true; // Мы ожидаем исключение ArithmeticException при переполнении
        }
        try {
            Calculator.calculation(Integer.MIN_VALUE, -1, '+');
            assert false; // Если мы здесь, значит, ожидаемого исключения не было
        } catch (ArithmeticException e) {
            assert true; // Мы ожидаем исключение ArithmeticException при переполнении
        }
        // Проверка деления на ноль
        try {
            Calculator.calculation(1, 0, '/');
            assert false; // Если мы здесь, значит, ожидаемого исключения не было
        } catch (ArithmeticException e) {
            assert true; // Мы ожидаем исключение ArithmeticException при делении на ноль
        }

        // Проверка неправильного оператора
        try {
            Calculator.calculation(1, 1, 'a');
            assert false; // Если мы здесь, значит, ожидаемого исключения не было
        } catch (IllegalStateException e) {
            assert true; // Мы ожидаем исключение IllegalStateException при использовании неправильного оператора
        }


        // Отрицательные числа. Сумма покупки
        // Ожидаемый результат: ошибка ArithmeticException с описанием "Сумма покупки не может быть отрицательной"
        assertThatThrownBy(() ->
                Calculator.calculateDiscount(-1000, 50))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");

        // Отрицательные числа. Процент
        // Ожидаемый результат: ошибка ArithmeticException с описанием "Скидка должна быть в диапазоне от 0 до 100%"
        assertThatThrownBy(() ->
                Calculator.calculateDiscount(1000, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");

        // Процент > 100
        // Ожидаемый результат: ошибка ArithmeticException с описанием "Скидка должна быть в диапазоне от 0 до 100%"
        assertThatThrownBy(() ->
                Calculator.calculateDiscount(1000, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");

/*
В классе Calculator создайте метод calculateDiscount, который принимает сумму покупки и процент скидки и возвращает сумму с учетом скидки.
Ваша задача - проверить этот метод с использованием библиотеки AssertJ.
Если метод calculateDiscount получает недопустимые аргументы, он должен выбрасывать исключение ArithmeticException.
Не забудьте написать тесты для проверки этого поведения.
 */

        assert 9500.00 == Calculator.calculateDiscount(10000.00, 5);
        assert 18000.00 == Calculator.calculateDiscount(20000.00, 10);
        assert 18000.00 == Calculator.calculateDiscount(-1, 15);
        assert 5 == Calculator.squareRootExtraction(25);

    }

    @Test
    void additionExpressionEvaluation() {
        assertThat(Calculator.calculation(2,6,'+')).isEqualTo(8);
    }

    @Test
    void evaluatesExpression() {
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
    }

    @Test
    void subtractionExpression() {
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
    }

    @Test
    void multiplicationExpression() {
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
    }

    @Test
    void divisionExpression() {
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);
    }

    @Test
    void expectedIllegalStateExpression() {
        assertThatThrownBy(() -> Calculator.calculation(7, 4, '_'))
                .isInstanceOf(IllegalStateException.class);
    }
}