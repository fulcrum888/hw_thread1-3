import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = generateArray(10000000, 50);
        ArraySumCalculator sumCalculator = new ArraySumCalculator(0, array.length, array);

        System.out.println("Вычисляю сумму в нескольких потоках:");
        long startTime= System.currentTimeMillis();
        long result = sumCalculator.compute();
        System.out.printf("Время выполнения: %dмс\n", System.currentTimeMillis() - startTime);

        System.out.println("Вычисляю сумму в одном потоке:");
        long startTime2= System.currentTimeMillis();
        calculateArraySumInOneThread(array);
        System.out.printf("Время выполнения: %dмс\n", System.currentTimeMillis() - startTime2);

        System.out.printf("Сумма элементов массива = %d\n", result);
        System.out.printf("Среднее значение массива = %.5f\n", (float)result / array.length);
    }

    static private int[] generateArray(int arrayLength, int maxValue) {
        int[] array = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(maxValue+1);
        }
        return array;
    }

    static private int calculateArraySumInOneThread(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum +=element;
        }
        return sum;
    }
}
