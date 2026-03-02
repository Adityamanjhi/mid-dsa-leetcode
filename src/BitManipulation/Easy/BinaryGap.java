package BitManipulation.Easy;

public class BinaryGap {

    static int gap(int n) {
        int maxGap = 0;
        int startIndex = -1;
        int endIndex = 0;
        while(n > 0) {
            int modulo = n%2;
            n = n / 2;
            if(modulo != 0) {
                if(startIndex == -1) {
                    startIndex = endIndex;
                }
                maxGap = Math.max(maxGap, endIndex - startIndex);
                startIndex = endIndex;
            }
            endIndex++;
        }
        return maxGap;
    }
    public static void main(String[] args) {
        int num = 22; //5,1,3 {4,5,6,7,0,1,2};
        System.out.println(gap(num));
    }
}
