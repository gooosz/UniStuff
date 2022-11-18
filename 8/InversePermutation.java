import java.util.Arrays;

public class InversePermutation {
    public static void main(String[] args) {
        //[3, 0, 4, 2, 1]
        int[] a = {3,0,4,2,1};
        //int[] a= {2,0,1};
        System.out.println(Arrays.toString(a));
        System.out.println("---------");
        System.out.println(Arrays.toString(inversePermutation(a)));
    }

    public static int[] inversePermutation(int[] a) {
        int[] b = new int[a.length];
        for (int i=0; i<a.length; i++) {
            b[a[i]] = i;
        }
        return b;
    }
}
