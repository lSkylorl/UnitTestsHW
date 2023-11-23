import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ControllerTest {

    int[] array;
    double averageArray;
    double averageArray1;
    Controller controllerMock;

    @BeforeEach
    void setUp() {
        array = new int[]{1, 1, 1, 1, 1};
        averageArray = 1.0;
        averageArray1 = 2.0;
        controllerMock = mock(Controller.class);
    }

    @Test
    void averageArray() {
        when(controllerMock.averageArray(array)).thenReturn(averageArray);
    }

    @Test
    void compareArray() {
        controllerMock.compareArray(averageArray, averageArray1);
        verify(controllerMock, times(1)).compareArray(averageArray, averageArray1);
    }

    @Test
    void createArray() {
        when(controllerMock.createArray()).thenReturn(array);
    }
}