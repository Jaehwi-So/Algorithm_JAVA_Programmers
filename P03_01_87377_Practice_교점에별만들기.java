package P03_01_87377_Practice_교점에별만들기;
import java.util.*;

class Solution {
    public int minX = Integer.MAX_VALUE;
    public int minY = Integer.MAX_VALUE;
    public int maxX = Integer.MIN_VALUE;
    public int maxY = Integer.MIN_VALUE;

    //교점
    List<int[]> points = new ArrayList<>();

    //2.평행 혹은 일치여부 확인하기
    public boolean isParallelOrEqual(int x1, int x2, int y1, int y2){
        if(((x1 * y2) - (x2 * y1)) == 0){
            return true;
        }
        else{
            return false;
        }
    }


    //3. 교점 X 구하기
    public Integer findX(int x1, int x2, int c1, int c2, int y1, int y2){
        double result = ((double)(y1 * c2) - (c1 * y2)) / ((x1 * y2) - (y1 * x2));
        return (result == (int)result) ? (int)result : null;
    }

    //4. 교점 Y
    public Integer findY(int x1, int x2, int c1, int c2, int y1, int y2){
        double result = ((double)(c1 * x2) - (x1 * c2)) / ((x1 * y2) - (y1 * x2));
        return (result == (int)result) ? (int)result : null;
    }


    //5. 좌표 최댓값, 최소값 갱신
    public void changeMaxAndMin(int x, int y){
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
    public String[] makeStar(){
        int length = maxY - minY + 1;
        String[] answer = new String[length];
        boolean contains = false;
        for(int j = this.maxY; j >= minY; j--){
            String s = "";
            for(int i = this.minX; i <= maxX; i++){
                int[] point = {i, j};
                contains = false;
                for(int[] p : points){
                    if (Arrays.equals(p, point)) {
                        contains = true;
                        break;
                    }
                }
                if(contains){
                    s += "*";
                }
                else{
                    s += ".";
                }
            }
            answer[this.maxY - j] = s;
        }

        return answer;

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
                //2. 평행, 일치여부 확인
                boolean isNotExistPoint = this.isParallelOrEqual(x1, x2, y1, y2);
                if(!isNotExistPoint){
                    //3, 4. X,Y 교점 구하기
                    Integer findX = this.findX(x1, x2, c1, c2, y1, y2);
                    Integer findY = this.findY(x1, x2, c1, c2, y1, y2);
                    if(findX != null && findY != null){ //만약 교점이 둘 다 정수라면
                        this.changeMaxAndMin((int)findX, (int)findY);   //5. x, y 최대/최솟값 갱신
                        int[] point = {(int)findX, (int)findY};
                        this.points.add(point); //6. 찾은 교점 리스트에 추가
                    }
                }
            }
        }

        //7. 좌표 문자열 만들기
        String[] answer = this.makeStar();
        return answer;
    }
}

public class P03_01_87377_Practice_교점에별만들기 {
    public static void main(String[] args) {
        int[][] input  = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        Solution s = new Solution();
        String[] result = s.solution(input);
        for(String str : result){
            System.out.println(str);
        }

    }
}