package BitsRelated;

public class NumberOfBits {

        public static void main(String[] args) {
            Solution solution = new Solution();

            int n = 11; // binary: 1011
            System.out.println("Number of 1 bits: " + solution.hammingWeight(n));
        }
    }

    class Solution {
        public int hammingWeight(int n) {
            int count = 0;
//          Each n & (n − 1) operation removes the lowest set bit, so counting iterations gives the number of 1s.
            while (n != 0) {
                n = n & (n - 1);
                count++;
            }
            return count;
        }
    }


