package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class MyListTest {
    int[] array1;
    int[] array2;
    int[] array3;
    MyList mylist;
    MyList mylistMock;
    double averageArray;
    double averageArray1;

    @BeforeEach
    void setUp() {
        mylist = new MyList();
        mylistMock = mock(MyList.class);
        array1 = new int[]{1,1,1,1,1};
        array2 = new int[]{1,1,1,1,1};
        array3 = new int[]{1,2,1,3,4};
        averageArray = 1.0;
        averageArray1 = 2.0;
    }

    @Test
    void compareArray() {
        double average1 = mylist.averageArray(array2);
        double average2 = mylist.averageArray(array1);
        mylist.compareArray(average1, average2);
    }

    @Test
    void averageArray() {
        assertThat(mylist.averageArray(array3)).isEqualTo(2.0);
        when(mylistMock.averageArray(array3)).thenReturn(averageArray);
    }

    @Test
    void createArray() {
        assertThat(mylist.createArray().length).isEqualTo(10);
        when(mylistMock.createArray()).thenReturn(array3);
    }

    @Test
    void createMyList(){
        when(mylistMock.createArray()).thenReturn(new int[]{1,1,1,1,1});
    }
}