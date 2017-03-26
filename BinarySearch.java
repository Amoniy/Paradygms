package Paradygms;

public class BinarySearch {
    //array.length >= 0 && для всех i>1 array[i-1] >= array[i] && i > l && i <= r
    public static int binIterative(int x, int[] array) {
        int l = -1;
        int r = array.length;
        // i > l && i <= r
        while (r > l + 1) {
            // r > l + 1
            int m = (l + r) / 2;
            // m > l && m < r
            if (array[m] <= x) {
                // i > l && i <= m
                r = m;
                // i > l && i <= r && r' > r
            } else {
                // i > m && i <= r
                l = m;
                // i > l && i <= r %% l' < l
            }
        }
        // i > l && i <= r
        // r - l == 1
        return r;
    } // i > l && i <= r

    // l == -1, r == array.length, ret == 0, array.length >= 0 && для всех i>1 array[i-1] >= array[i] && ret > l && ret <= r
    public static int binRecursive(int x, int[] array, int l, int r, int ret) {
        // ret > l && ret <= r
        if (r > l + 1) { // ret > l && ret <= r && r > l + 1
            int m = (l + r) / 2;
            // m > l && m < r
            if (array[m] <= x) {
                // ret > l && ret <= m
                r = m;
                // ret > l && ret <= r && r' > r
            } else {
                // ret > m && ret <= r
                l = m;
                // ret > l && ret <= r && l' < l
            }
            // ret > l && ret <= r
            ret = binRecursive(x, array, l, r, ret);
            // ret > l && ret <= r
        } else { // ret > l && ret <= r && r - l == 1
            ret = r;
            // ret == r
        }
        return ret;
    } // ret > l && ret <= r

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
        binAns = binIterative(x, array);
        recAns = binRecursive(x, array, -1, array.length, 0);
        //System.out.println(binAns);
        System.out.println(recAns);
    }
    // R == binAns || R == recAns
}
