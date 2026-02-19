package BitsRelated;

public class ReverseBits {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 43261596; // 00000010100101000001111010011100
        int reversed = reverseBits(n);

        System.out.println("Reversed bits: " + reversed);
    }

    public static int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;          // make space
            result |= (n & 1);     // copy last bit
            n >>>= 1;              // unsigned shift
        }
        return result;
    }
}

