public class RomanToInt {

    public static void main(String[] args) {
        String roman = "MCMXCIV";
        int result = romanToInt(roman);

        System.out.println("Roman: " + roman);
        System.out.println("Integer: " + result);
    }

    public static int romanToInt(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int curr = value(s.charAt(i));
            int next = (i + 1 < s.length()) ? value(s.charAt(i + 1)) : 0;

//            If a Roman numeral is smaller than the one after it, subtract it; otherwise, add it.

            if (curr < next) {
                result -= curr;
            } else {
                result += curr;
            }
        }
        return result;
    }

    private static int value(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

