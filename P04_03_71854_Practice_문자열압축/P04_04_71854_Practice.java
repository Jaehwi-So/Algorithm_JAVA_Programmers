package P04_03_71854_Practice_문자열압축;


class Solution {

    String best = new String(new char[1000]);

    public int solution(String s) {

        for(int n = 1; n <= s.length(); n++){
            String bar = "";
            int cur = 0;

            String before = "";
            int count = 0;
            while(cur < s.length()){
                String foo;
                if(cur + n > s.length()){
                    foo = s.substring(cur, s.length());
                }
                else{
                    foo = s.substring(cur, cur + n);
                }
                if(foo.equals(before)){
                    count++;
                }
                //앞의 단어와 일치하지 않는 경우
                else{
                    if(count > 1){
                        bar += count;
                        bar += foo;
                    }
                    else {
                        bar += foo;
                    }

                    count = 1;
                }
                before = foo;
                cur += n;
            }

            if(count > 1){
                bar += count;
            }

            if(best.length() > bar.length()){
                best = bar;
            }

        }
        return best.length();
    }
}


public class P04_04_71854_Practice {
    public static void main(String[] args) {
        String str = "ababcdcdababcdcd";
        Solution s = new Solution();
        int result = s.solution(str);
        System.out.println(result);
    }
}


