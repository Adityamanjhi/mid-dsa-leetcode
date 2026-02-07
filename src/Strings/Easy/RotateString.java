package Strings.Easy;

public class RotateString {

    static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }
        String doubleS = s.concat(s);
        for(int i = 0; i < s.length(); i++) {
            if(doubleS.substring(i, i + s.length()).equals(goal)) {
                return true;
            }
        }
        return false;
    }

    static boolean rotateStringSol2(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }
        String doubleS = s.concat(s);
        return doubleS.contains(goal);
    }

    public static void main(String[] args) {
        String s = "rotation";
        String target = "tionrota";
        System.out.println(rotateStringSol2(s, target));
    }
}
