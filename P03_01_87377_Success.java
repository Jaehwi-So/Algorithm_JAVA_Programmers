package P03_01_87377_Answer_교점에별만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    public long minX = Long.MAX_VALUE;
    public long minY = Long.MAX_VALUE;
    public long maxX = Long.MIN_VALUE;
    public long maxY = Long.MIN_VALUE;

    //교점
    List<long[]> points = new ArrayList<>();

    //3. 교점 X
    public Long findX(long x1, long x2, long c1, long c2, long y1, long y2){
        double result = ((double)(y1 * c2) - (c1 * y2)) / ((x1 * y2) - (y1 * x2));
        return (result % 1 == 0) ? (long)result : null;
    }

    //4. 교점 Y
    public Long findY(long x1, long x2, long c1, long c2, long y1, long y2){
        double result = ((double)(c1 * x2) - (x1 * c2)) / ((x1 * y2) - (y1 * x2));
        return (result % 1 == 0) ? (long)result : null;
    }


    //5. 좌표 최댓값, 최소값 갱신
    public void changeMaxAndMin(long x, long y){
        if(x < minX){
            minX = x;
        }
        if(x > maxX){
            maxX = x;
        }

        if(y < minY){
            minY = y;
        }
        if(y > maxY){
            maxY = y;
        }
    }

    //7. 좌표 문자열 만들기
//    public String[] makeStar(){
//        int length = maxY - minY + 1;
//        String[] answer = new String[length];
//        boolean contains = false;
//        for(int j = this.maxY; j >= minY; j--){
//            String s = "";
//            for(int i = this.minX; i <= maxX; i++){
//                int[] point = {i, j};
//                contains = false;
//                for(int[] p : points){
//                    if (Arrays.equals(p, point)) {
//                        contains = true;
//                        break;
//                    }
//                }
//                if(contains){
//                    s += "*";
//                }
//                else{
//                    s += ".";
//                }
//            }
//            answer[this.maxY - j] = s;
//        }
//        return answer;
//    }

    public String[] makeStar(){
        int width = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);
        char[][] answer = new char[height][width];
        for(char[] row: answer){
            Arrays.fill(row, '.');
        }
        for(long[] point: points){
            answer[(int)(maxY - point[1])][(int)(point[0] - minX)] = '*';
        }

        String[] result = new String[answer.length];
        for(int i = 0; i < answer.length; i++){
            result[i] = new String(answer[i]);
        }
        return result;
    }

    //입력 = [[x, y, 상수]]
    public String[] solution(int[][] line) {

        //1. 입력에 대한 순회
        for(int i = 0; i < line.length; i++){
            for(int j = i + 1; j < line.length; j++){
                int x1 = line[i][0];
                int x2 = line[j][0];
                int y1 = line[i][1];
                int y2 = line[j][1];
                int c1 = line[i][2];
                int c2 = line[j][2];
                //2. 평행, 일치여부 확인(X)
                //3, 4. X,Y 교점 구하기
                Long findX = this.findX(x1, x2, c1, c2, y1, y2);
                Long findY = this.findY(x1, x2, c1, c2, y1, y2);
                if(findX != null && findY != null){ //만약 교점이 둘 다 정수라면
                    this.changeMaxAndMin(findX, findY);   //5. x, y 최대/최솟값 갱신
                    long[] point = {findX, findY};
                    this.points.add(point); //6. 찾은 교점 리스트에 추가
                }
            }
        }

        //7. 좌표 문자열 만들기
        String[] answer = this.makeStar();
        return answer;
    }
}
public class P03_01_87377_Success {


    public static void main(String[] args) {
        int[][] input  = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        Solution s = new Solution();
        String[] result = s.solution(input);
        for(String str : result){
            System.out.println(str);
        }

    }
}


//1. 평행/일치 여부 로직 삭제 -> 교점 로직에서 % 연산으로 알고리즘 변경하여 해당 케이스일 경우에도 포인트로 취급 안하도록 변경
//2. 별 찍기 로직 간소화
//3. 런타임 에러 이유 -> AD-BC, BF-ED..의 값의 범위가 int를 넘어감 -> long으로 변경해야 함