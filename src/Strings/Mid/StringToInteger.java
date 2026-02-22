package Strings.Mid;

public class StringToInteger {
    static int MIN_INT = (int) -Math.pow(2, 31);
    static int MAX_INT = (int) Math.pow(2, 31);

    static int myAtoi(String s) {
        int res = 0;
        int bit = 0;
        int minInt = (int) -Math.pow(2, 31);
        int maxInt = (int) Math.pow(2, 31);
        for(char ch: s.toCharArray()) {
            if(ch == ' ') {
                if(bit == 0) {
                    continue;
                }
                break;
            }
            if(ch == '+' || ch == '-') {
                if(bit != 0) {
                    break;
                }
                bit = ch == '+' ? 1 : -1;
                continue;
            }
            int num = ch - '0';
            if(num >= 0 && num <= 9) {
                if(bit == 0) {
                    bit = 1;
                }
                if(bit == -1 && ((-1 * res * 10L) - num) <= minInt) {
                    return minInt;
                }
                if(bit == 1 && (res* 10L + num) >= maxInt ) {
                    return maxInt;
                }
                res = res*10 + num;
                continue;
            }
            break;
        }
        return res*bit;
    }

    static int getAtoiNumber(int i, String s, int sign, long sum) {
        if(i >= s.length() || !Character.isDigit(s.charAt(i))) {
            return (int)(sign*sum);
        }
        sum = sum*10 + (s.charAt(i) - '0');
        if(sign*sum <= MIN_INT) return MIN_INT;
        if(sign*sum >= MAX_INT) return  MAX_INT;
        return getAtoiNumber(i+1, s, sign, sum);
    }

    static int myAtoiSol2(String s) {
        int i = 0;
        while(i < s.length() && s.charAt(i) == ' ') i++;
        int sign = 1;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }
        return getAtoiNumber(i, s, sign, 0);
    }

    public static void main(String[] args) {
        String s = "   -042";// "-00042";
        System.out.println(myAtoiSol2(s));
    }
}
