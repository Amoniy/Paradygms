package Paradygms;

public class BinarySearchMissing {
    //array.length >= 0 && для всех i [1;len-1] array[i-1] >= array[i] && I > l && I <= r
    public static int binIterative(int x, int[] array) {
        int l = -1;
        int r = array.length;
        // r > l
        // I > l && I <= r
        while (r > l + 1) {// r > l + 1
            int m = (l + r) / 2;
            // m >= l && m < r
            if (array[m] <= x) {// I > l && I <= m

                r = m;
                // I > l && I <= r && r' > r
            } else {// I > m && I <= r

                l = m;
                // I > l && I <= r && l' < l
            }
        }

        // l >= r  =>  array[r] >= array[l]
        // array[right] <= x && x <= array[l]
        // =>  x = array[r] && x = array[l]  POST


        // I > l && I <= r && a[l] > key && a[r] <= key
        // r - l == 1
        if (array.length == 0 || r >= array.length) {
            r = r * (-1) - 1;
            // R = -r - 1
        } else if (array[r] != x) {
            r = r * (-1) - 1;
            // R = -r - 1
        }
        return r;
        // R = r
    } // R == r &&          array.length >= 0 && для всех i [1;len-1] array[i-1] >= array[i] && I > l && I <= r

    // l == -1, r == array.length, array.length >= 0 && для всех i [1;len-1] array[i-1] >= array[i] && I > l && I <= r
    // PRED l >= -1 && r <= length && array[I-1] >= array[I] && i > l && i <= r
    public static int binRecursive(int x, int[] array, int l, int r) {
        // I > l && I <= r
        if (r > l + 1) {// l < r - 1
            int m = (l + r) / 2;
            // m >= l && m < r
            if (array[m] <= x) { // array[m] <= x array[l] >= x
                // I > l && I <= m
                r = m;
                // I > l && I <= r && r' > r
            } else { // array[m] > x     => I > m && I <= r

                l = m;
                // I > m && l = m && I <= r  =>  I > l && I <= r && l' < l
            }

            // (l' < l  ||  l' = l) && l' >= -1 =>  l >= -1
            // (r' > r  ||  r' = r) && r' <= length =>  r <= length
            // array[i-1] >= array[i]
            // I > l && I <= r
            r = binRecursive(x, array, l, r);
            // (l' < l  ||  l' = l) && l' >= -1 =>  l >= -1
            // (r' > r  ||  r' = r) && r' <= length =>  r <= length
            // array[i-1] >= array[i]
        } else { // I > l && I <= r && r - l == 1  =>  I == r
            //

            // l >= r  =>  array[r] >= array[l]
            // array[r] <= x && x <= array[l]
            // =>  x = array[r] && x = array[l]
            if (array.length == 0 || r >= array.length) {
                r = r * (-1) - 1;
            } else if (array[r] != x) {
                r = r * (-1) - 1;
            }
        }
        return r;
    } // POST l >= -1 && r <= length && array[i-1] >= array[i] && I > l && I <= r
    // R == r

    // args.length > 0 && для всех i>1 args[i-1] >= args[i]
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int[] array = new int[args.length - 1];
        // для всех i>1 args[i-1] >= args[i]
        for (int i = 0; i < args.length - 1; i++) {
            array[i] = Integer.parseInt(args[i + 1]);
        }
        // для всех i>1 array[i-1] >= array[i]
        int binAns = 0;
        int recAns = 0;

        // для всех i [1;len-1] array[i-1] >= array[i] && i > l && i <= r
        binAns = binIterative(x, array);

        // l >= -1 && r <= length && array[i-1] >= array[i] && i > l && i <= r
        recAns = binRecursive(x, array, -1, array.length);
        //System.out.println(binAns);
        System.out.println(recAns);
    }
    // R == binAns || R == recAns
}
