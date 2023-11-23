import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SomeServiceTest {
    private SomeService someService;

    @BeforeEach
    void setUp() {
        someService = new SomeService();
    }


    @Test
    void discount50() {
        assertThat(someService.calculatingDiscount(100.0, 50))
                .isEqualTo(50);
    }

    @Test
    void discount100() {
        assertThat(someService.calculatingDiscount(100.0, 100))
                .isEqualTo(0);
    }

    @Test
    void discount0() {
        assertThat(someService.calculatingDiscount(100.0, 0))
                .isEqualTo(100);
    }

    @Test
    void negativeDiscount() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(100.0, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }

    @Test
    void discountMore100() {
        assertThatThrownBy(() -> someService.calculatingDiscount(100.0, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }

    @Test
    void negativePurchaseAmount() {
        assertThatThrownBy(() -> someService.calculatingDiscount(-100.0, 20))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");
    }
    @Test
    void evenNumber(){
        assertTrue(someService.evenOddNumber(2));
    }
    @Test
    void oddNumber(){
        assertFalse(someService.evenOddNumber(1));
    }
    @Test
    void intervalLow(){
        assertTrue(someService.numberInInterval(25));
    }
    @Test
    void intervalHigh(){
        assertTrue(someService.numberInInterval(100));
    }
    @Test
    void intervalMidl(){
        assertTrue(someService.numberInInterval(50));
    }
    @Test
    void underInterval(){
        assertFalse(someService.numberInInterval(24));
    }
    @Test
    void beyondInterval(){
        assertFalse(someService.numberInInterval(101));
}