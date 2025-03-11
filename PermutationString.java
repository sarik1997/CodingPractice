public class PermutationString {
    public static void mf(String str, String result) {
        if (str.equals("")) {
            System.out.println(result);
            return;
        }
        for (int i = 0; i < str.length(); ++i) {
            result += str.charAt(i);
            mf(str.substring(0, i ) + str.substring(i+1,str.length()), result);
            result = result.substring(0, result.length() - 1);
        }
    }

    public static void main(String args[]){
        String name = "ABC";
        String result = "";
        mf(name, "");
    }
}
