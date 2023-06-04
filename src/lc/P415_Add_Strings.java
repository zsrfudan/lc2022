package lc;

public class P415_Add_Strings {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() < 1) {
            return num2;
        }
        if (num2 == null || num2.length() < 1) {
            return num1;
        }
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int  flag = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0 || flag > 0) {
            int n1 = 0, n2 = 0;
            if (i >= 0) {
                n1 = num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                n2 = num2.charAt(j) - '0';
                j--;
            }
            sb.append((n1 + n2 + flag) % 10);
            flag = (n1 + n2 + flag) / 10;
        }
        return sb.reverse().toString();
    }
}