public class Main {

    public static void main(String[] args){

        Controller controller = new Controller();

        int[] array1 = controller.createArray();
        double averageArray1 = controller.averageArray(array1);

        int[] array2 = controller.createArray();
        double averageArray2 = controller.averageArray(array2);

        controller.compareArray(averageArray1, averageArray2);
    }
}