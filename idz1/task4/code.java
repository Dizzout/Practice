public class BinarySearch {
    public static void main(String[] args) {
        int data[] = {3, 6, 7, 10, 34, 56, 60};
        int numberToFind = 10;

        int low = 0;
        int high = data.length - 1;
        int position = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (data[mid] == numberToFind) {
                position = mid;
                break;
            } else if (data[mid] < numberToFind) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(position);
    }
}

