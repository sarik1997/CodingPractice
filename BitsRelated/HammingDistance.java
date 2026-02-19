package BitsRelated;

public class HammingDistance {

    public static void main(String[] args) {

        int x = 1; // 0001
        int y = 4; // 0100

        System.out.println("Hamming Distance: " + hammingDistance(x, y));

    }

    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;// XOR highlights differing bits
        int count = 0;

        while (xor != 0) {// and counting the 1s gives the Hamming distance.
            xor = xor & (xor - 1); // removes rightmost 1
            count++;
        }
        return count;
    }
}

