package P04_05_71855_Practice_3진법뒤집기;


class Solution {

    public int solution(int n) {

        int answer = 0;
        StringBuilder builder = new StringBuilder();
        int max = 3;

        while(max * 3 <= n){
            max *= 3;
        }

        int bar = n;
        for(int i = max; i > 0; i /= 3){
            int foo = bar / i;
            bar = bar % i;
            builder.append(foo);
        }

        Long tmp = Long.parseLong(builder.toString());
        String tmps = Long.toString(tmp);


        char[] SamZinNum = tmps.toCharArray();
        for(int i = 0; i < SamZinNum.length; i++){

            long number = Character.getNumericValue(SamZinNum[i]);
            if(number== 0){
                continue;
            }
            long a = 1;
            for(int j = 0; j < i; j++){
                a *= 3;
            }

//            System.out.println(a + " " + number);
            answer += (number * a) == 0 ? 1 : (number * a);
        }

        return answer;
    }
}

// 100 > 001 -> 1
public class P04_05_71855_Practice {
    public static void main(String[] args) {
        int n = 125;
        Solution s = new Solution();
        int result = s.solution(n);
        System.out.println(result);
    }
}


