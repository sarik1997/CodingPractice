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

/**
 * The String Pool (also called the intern pool) is a
 * special memory region in Java that stores
 * unique string literals to save memory and improve performance.
 *
 * 🧠 What It Does:
 *
 * When you write a string like this:
 * String s1 = "hello";
 * String s2 = "hello";
 * Java does not create two separate string objects. Instead:
 * 	•	It creates the string "hello" in the String Pool (if it’s not already there).
 * 	•	Both s1 and s2 point to the same object in memory.
 *
 * This works because strings in Java are immutable (they can’t be changed), so it’s safe to reuse them.
 *
 * ⸻
 *
 * 🔁 Example with .intern():
 * String s1 = new String("hello"); // created in heap, not pool
 * String s2 = "hello";             // from string pool
 *
 * System.out.println(s1 == s2);          // false
 * System.out.println(s1.intern() == s2); // true
 * 	•	s1.intern() tells Java: “Put this string in the pool (or return the existing one).”
 * 	•	Then it matches the pooled version that s2 already references.
 *
 * ⸻
 *
 * ✅ Why Use String Pool?
 * 	•	Memory efficiency: Reuses identical strings.
 * 	•	Faster comparisons: Reference (==) checks can work when strings come from the pool.
 * 	🔧 How the String Pool is Created:
 *
 * In Java, the String Pool is created and managed automatically by the JVM (Java Virtual Machine).
 * 	•	It’s part of the method area (or metaspace in newer Java versions, Java 8+).
 * 	•	The JVM creates the pool when it starts up.
 * 	•	All string literals and any string you call .intern() on are stored there.
 *
 * ♻️ Is the String Pool Garbage Collected (GC’ed)?
 *
 * Yes — but with conditions:
 *
 * Java 6 and earlier:
 * 	•	String Pool was part of PermGen (Permanent Generation).
 * 	•	Not garbage collected — limited and could cause OutOfMemoryError.
 *
 * Java 7 and newer (Java 8+):
 * 	•	String Pool moved to Heap (via Metaspace).
 * 	•	So yes, it can now be garbage collected.
 *
 * But:
 * 	•	String literals ("example") are typically not collected until the class is unloaded (which usually means when the classloader is GC’d).
 * 	•	Interned strings created dynamically (new String(...).intern()) can be collected if they are no longer referenced.
 *
 * ⸻
 *
 * ⚠️ Practical Note:
 *
 * You generally don’t manage the String Pool manually — the JVM optimizes it for you. Overusing .intern() on dynamically created strings can cause memory pressure if you’re not careful.
 */
