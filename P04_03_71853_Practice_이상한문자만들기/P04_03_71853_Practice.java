package P04_03_71853_Practice_이상한문자만들기;

class Solution {
    public String solution(String s) {

        char[] str = s.toCharArray();

        boolean isUpper = true;
        for(int i = 0; i < str.length; i++){
            if(str[i] == ' '){
                isUpper = true;
                continue;
            }
            else{
                if(isUpper == true){
                    str[i] = Character.toUpperCase(str[i]);
                    isUpper = false;
                }
                else{
                    str[i] = Character.toLowerCase(str[i]);
                    isUpper = true;
                }
            }
        }

        String answer = new String(str);
        return answer;
    }
}

public class P04_03_71853_Practice {
    public static void main(String[] args) {
        String str = "try hello world   ";
        Solution s = new Solution();
        String result = s.solution(str);
        System.out.println(result);
    }
}