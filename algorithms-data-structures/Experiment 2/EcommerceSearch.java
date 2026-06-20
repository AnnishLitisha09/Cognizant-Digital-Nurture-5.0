import java.util.*;

public class EcommerceSearch {

    public static int linearSearch(String[] products, String target) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(String[] products, String target) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int cmp = products[mid].compareToIgnoreCase(target);

            if (cmp == 0)
                return mid;
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] products = {
                "Laptop",
                "Phone",
                "Shoes",
                "Watch"
        };

        System.out.print("Enter product name: ");
        String target = sc.nextLine();

        int linearResult = linearSearch(products, target);

        if (linearResult != -1)
            System.out.println("Found using Linear Search");
        else
            System.out.println("Not Found using Linear Search");

        Arrays.sort(products);

        int binaryResult = binarySearch(products, target);

        if (binaryResult != -1)
            System.out.println("Found using Binary Search");
        else
            System.out.println("Not Found using Binary Search");

        sc.close();
    }
}