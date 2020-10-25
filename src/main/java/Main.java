import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = generateArray(8, 50);
        ArraySumCalculator sumCalculator = new ArraySumCalculator(0, array.length, array);
        long result = sumCalculator.compute();
        System.out.println(result);
    }

    static private int[] generateArray(int arrayLength, int maxValue) {
        int[] array = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(maxValue+1);
        }
        return array;
    }
}
