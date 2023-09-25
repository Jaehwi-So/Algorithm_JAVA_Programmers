package P04_02_71852_Practice_시저암호;

class Solution {
    public String solution(String s, int n) {
        char[] array = s.toCharArray();

        for(int i = 0; i < array.length; i++){
            if(array[i] == ' '){
                continue;
            }
            int number = (int)array[i];
            int pNum = number + n;
            if((int)number <= 90 && pNum > 90) {
                pNum -= 26;
            }
            if((int)number <= 122 && pNum > 122) {
                pNum -= 26;
            }
            array[i] = (char)pNum;
        }
        StringBuilder bulider = new StringBuilder();
        String answer = bulider.append(array).toString();
        return answer;
    }
}

public class P04_02_71852_Practice {
    public static void main(String[] args) {
        String str = "a B Z";
        int n = 4;
        Solution s = new Solution();
        String result = s.solution(str, n);
        System.out.println(result);
    }
}