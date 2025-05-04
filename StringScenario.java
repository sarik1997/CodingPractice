import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringScenario {
    public static void main(String[] args) {
        Map<Character, Integer> hashMap = new HashMap<>();
        //new keyword will store it in heap-memory
        String s1 = new String("hello");
        //stringpool
        String s2 = "hello";
        String s3 = s1.intern();//returns string from pool, now it will be same as s2
        System.out.println(s1 == s2);//false because reference variables are pointing to different instance
        System.out.println(s2 == s3);//true because reference variables are pointing to same instance
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        hashMap.forEach((K, V) -> System.out.println(K + " count : " + V));
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ", counts : " + entry.getValue());
        }
        String input = "gainjavaknowledge";

        Map<String, Long> output = Arrays.stream(input.split("")).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Output : " + output);

    }
}

class Geeks
{
    // Iterative function to
    // reverse the digits of number
    static int reversNumber(int n)
    {
        int reversed_n = 0;
        while (n > 0) {
            reversed_n = reversed_n * 10 + n % 10;
            n = n / 10;
        }
        return reversed_n;
    }

    // Main function
    public static void main(String[] args)
    {
        int n = 123464321;
        int reverseN = reversNumber(n);
        System.out.println("Reverse of n = " + reverseN);

        // Checking if n is same
        // as reverse of n
        if (n == reverseN)
            System.out.println("Palindrome = Yes");
        else
            System.out.println("Palindrome = No");
    }
}


