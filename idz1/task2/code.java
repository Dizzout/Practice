public class MatrixPrint {
    public static void main(String[] args) {
        int size = 5;

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (i == j || i == size - j + 1) {
                    System.out.print(" * ");
                } else {
                    int number = (i - 1) * size + j;
                    System.out.print(String.format("%2d ", number));
                }
            }
            System.out.println();
        }
    }
}

