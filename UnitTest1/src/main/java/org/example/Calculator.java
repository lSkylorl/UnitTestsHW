package org.example;

public class Calculator {

    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
    // необходимые проверки для него используя граничные случаи
    public static double squareRootExtraction(double num) {
        //  0
        //  Отрицательные числа
        //  Дробные значения корней
        //  Целые
            if(num < 0) {
                throw new IllegalArgumentException("Cannot calculate square root of a negative number");
            }
            return Math.sqrt(num);
    }

    /**
     * @param purchaseAmount сумма покупки
     * @param discountAmount размер скидки
     * @return возвращает сумму покупки с учетом скидки
     */
    public static double calculateDiscount(double purchaseAmount, int discountAmount) {
        if (purchaseAmount >= discountAmount && discountAmount > 0) {
            return switch (discountAmount) {
                case 5 -> purchaseAmount - purchaseAmount * 0.05;
                case 10 -> purchaseAmount - purchaseAmount * 0.10;
                case 15 -> purchaseAmount - purchaseAmount * 0.15;
                case 20 -> purchaseAmount - purchaseAmount * 0.20;
                case 25 -> purchaseAmount - purchaseAmount * 0.25;
                case 30 -> purchaseAmount - purchaseAmount * 0.30;
                case 35 -> purchaseAmount - purchaseAmount * 0.35;
                case 40 -> purchaseAmount - purchaseAmount * 0.40;
                case 45 -> purchaseAmount - purchaseAmount * 0.45;
                default -> purchaseAmount;
            };
        }
        else {
            throw new ArithmeticException("Возникла ошибка");
        }
    }
}