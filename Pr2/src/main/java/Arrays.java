class ArrayStat {

    public static int findMin(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути null або порожнім.");
        }
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int findMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути null або порожнім.");
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static double calculateAvg(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути null або порожнім.");
        }
        double sum = 0;
        for (int i = 0;  i < array.length; i++) {
            sum += array[i];
        }
        return (sum/array.length);
    }
}

public class Arrays {
    public static void main(String[] args) {
        int[] numbers = {10, -5, 8, 42, 0, -15};

        System.out.println("Min: " + ArrayStat.findMin(numbers));
        System.out.println("Max: " + ArrayStat.findMax(numbers));
        System.out.println("Avg: " + ArrayStat.calculateAvg(numbers));

        try {
            ArrayStat.findMin(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        try {
            ArrayStat.calculateAvg(new int[0]);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка:  " + e.getMessage());
        }
    }
}