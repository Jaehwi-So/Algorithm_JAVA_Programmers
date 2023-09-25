package P04_01_12932_Practice_자연수뒤집어배열로만들기;

class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        char[] list = str.toCharArray();
        int[] answer = new int[list.length];
        for(int i = 0; i < list.length; i++){
            int result = list[i] - '0';
            answer[list.length - (i + 1)] = result;
        }

        return answer;
    }
}

public class P04_01_12932_Practice {
    public static void main(String[] args) {
        int input = 12345;
        Solution s = new Solution();
        int[] result = s.solution(input);
        for(int i : result){
            System.out.println(i);
        }

    }
}