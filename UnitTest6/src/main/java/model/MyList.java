package model;
import java.util.Arrays;
import java.util.Random;

public class MyList implements IList {

    public MyList() {
    }

    @Override
    public void compareArray(double resultAverage1, double resultAverage2) {
        if(resultAverage1 == resultAverage2) {
            System.out.println("Средние значения массивов равны");
        } else if (resultAverage1 > resultAverage2) {
            System.out.println("Первый список имеет большее среднее значение");
        } else {
            System.out.println("Второй список имеет большее среднее значение");
        }
    }

    @Override
    public double averageArray(int[] array) {
        double sum = 0;
        for (int j : array) {
            sum = sum + j;
        }
        double resultAverage = Math.round(sum / array.length);
        System.out.println("\nСреднее значение списка = " + resultAverage + ".\n");
        return resultAverage;
    }

    public int[] createArray() {
       Random random = new Random();
       int[] array = random.ints(0, 100).distinct().limit(10).toArray();
       System.out.println(Arrays.toString(array));
       return array;
    }

}