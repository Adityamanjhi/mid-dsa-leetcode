package Strings.Easy;

public class MaximumNestingDepth {

    static int maxNestingDepth(String s) {
        int max = 0;
        int sum = 0;
        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                sum++;
            } else if(ch == ')') {
                sum--;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxNestingDepth(str));
    }
}
