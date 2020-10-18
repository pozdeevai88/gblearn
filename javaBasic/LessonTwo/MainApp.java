public class MainApp {
    public static void main(String[] args) {

        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

        int[] arr1 = { 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0 };

        for (int i = 0; i < arr1.length; i++) {
            if ( arr1[i] == 0) {
                arr1[i] = 1;
            } else {
                arr1[i] = 0;
            }
        }


        // 2. Задать пустой целочисленный массив размером 8.
        // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21

        int[] arr2 = new int[8];
        for (int i = 0; i < arr2.length ; i++) {
            arr2[i] = i*3;
        }


        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        // пройти по нему циклом, и числа меньшие 6 умножить на 2

        int[] arr3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr3.length; i++) {
            if ( arr3[i] < 6 ){
                arr3[i] *= 2;
            }
        }


        // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами

        int[][] arr4 = new int[5][5];
        for (int i = 0; i < 5; i++) {
            arr4[i][i] = 1;
            arr4[i][arr4.length - 1 - i] = 1;
        }


        // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы

        int[] arr5 = { 10, 5, 3, 2, 11, 4, 5, 2, 24, 8, 9, 1 };
        int min = arr5[0];
        int max = arr5[0];
        for (int i = 0; i < arr5.length; i++) {
            if ( arr5[i] < min ){
                min = arr5[i];
            }
            if ( arr5[i] > max ){
                max = arr5[i];
            }
        }


        // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        // граница показана символами ||, эти символы в массив не входят.

        int[] arr6 = { 1, 2, 3, 3, 3 };
        sideEquality(arr6);


        // 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
        // при этом метод должен сместить все элементымассива на n позиций.
        // Для усложнения задачи нельзя пользоваться вспомогательными массивами.

        int[] arr7 = { 7, 6, 5, 4, 8, 3, 2 };
        int shift = -3;
        arrShift(arr7, shift);

    }

    public static boolean sideEquality (int[] arr) {
        int sumLeft;
        int sumRight;
        for (int i = 0; i < arr.length; i++) {
            sumLeft = 0;
            sumRight = 0;
            for (int ii = 0; ii < arr.length; ii++) {
                if (ii <= i) {
                    sumLeft += arr[ii];
                } else {
                    sumRight += arr[ii];
                }
            }
            if (sumLeft == sumRight) {
                return true;
            }
        }
        return false;
    }


    public static void arrShift (int[] arr, int shift) {
        if (shift >= 0) {
            for (int s = 1; s <= shift; s++) {
                int n0 = arr[0];
                int n1;
                for (int i = 0; i < arr.length; i++) {
                    if (i == arr.length - 1) {
                        n1 = arr[0];
                        arr[0] = n0;
                    } else {
                        n1 = arr[i + 1];
                        arr[i + 1] = n0;
                        n0 = n1;
                    }
                }
            }
        } else {
            for (int s = 1; s <= shift*(-1); s++) {
                int n0 = arr[arr.length - 1];
                int n1;
                for (int i = arr.length - 1; i >= 0; i--) {
                    if (i == 0) {
                        n1 = arr[arr.length - 1];
                        arr[arr.length - 1] = n0;
                    } else {
                        n1 = arr[i - 1];
                        arr[i - 1] = n0;
                        n0 = n1;
                    }
                }
            }
        }
    }
}
