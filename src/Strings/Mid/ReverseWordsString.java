package Strings.Mid;

public class ReverseWordsString {

    static String reverseWords(String s) {
        StringBuilder reverseStr = new StringBuilder();
        int endPoint = s.length();
        int startPoint = endPoint;
        while(endPoint >= 0) {
            while(startPoint > 0 && s.charAt(startPoint - 1) != ' ') {
                startPoint -= 1;
            }
            if(startPoint < endPoint) {
                if(!reverseStr.toString().isEmpty()) {
                    reverseStr.append(" ");
                }
                reverseStr.append(s, startPoint, endPoint);
                endPoint = startPoint - 1;
                startPoint = endPoint;
            } else {
                endPoint = startPoint - 1;
                startPoint = endPoint;
            }
        }
        return reverseStr.toString();
    }

    static String reverseWordsSol2(String s) {
        StringBuilder reverseStr = new StringBuilder();
        int i = s.length() - 1;
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if(i < 0) {
                break;
            }
            int end = i;
            while(i >=0 && s.charAt(i) != ' ') {
                i--;
            }
            if(!reverseStr.isEmpty()) {
                reverseStr.append(' ');
            }
            reverseStr.append(s, i+1, end + 1);
        }
        return  reverseStr.toString();
    }


    public static void main(String[] args) {
        String str = " the sky is blue ";
        String reverseStr = reverseWords(str);
        String reverseStr2 = reverseWordsSol2(str);
        System.out.println("->>" + reverseStr + "<<-");
        System.out.println("->>" + reverseStr2 + "<<-");
    }
}
