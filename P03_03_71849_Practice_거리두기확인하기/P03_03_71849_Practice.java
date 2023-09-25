package P03_03_71849_Practice_거리두기확인하기;
import java.sql.Array;
import java.util.*;


class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        char[][][] array = new char[5][5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                char[] line = places[i][j].toCharArray();
                array[i][j] = line;
            }
        }

        boolean isLineHave = false;
        boolean isRoomHave = false;
        for(int i = 0; i < 5; i++){
            isRoomHave = false;
            for(int j = 0; j < 5; j++){
                isLineHave = false;

                for(int k = 0; k < 5; k++){
                    if(array[i][j][k] == 'P'){
                        //1차 상하좌우 체크
                        if(k+1 < 5 && array[i][j][k+1] == 'P'
                                || k-1 > -1 && array[i][j][k-1] == 'P'
                                || j+1 < 5 && array[i][j+1][k] == 'P'
                                || j-1 > -1 && array[i][j-1][k] == 'P'
                        ){
                            isLineHave = true;
                            break;
                        }

                        //2차 멘헤튼거리2 상하좌우 체크
                        if(k+2 < 5 && array[i][j][k+2] == 'P' && array[i][j][k+1] != 'X'
                                || k-2 > -1 && array[i][j][k-2] == 'P' && array[i][j][k-1] != 'X'
                                || j+2 < 5 && array[i][j+2][k] == 'P' && array[i][j+1][k] != 'X'
                                || j-2 > -1 && array[i][j-2][k] == 'P' && array[i][j-1][k] != 'X'
                        ){
                            isLineHave = true;
                            break;
                        }

                        //3차 대각 체크
                        if(k+1 < 5 && j+1 < 5 && array[i][j+1][k+1] == 'P' && (array[i][j][k+1] != 'X' || array[i][j+1][k] != 'X')
                                || k-1 > -1 && j+1 < 5 && array[i][j+1][k-1] == 'P' && (array[i][j][k-1] != 'X' || array[i][j+1][k] != 'X')
                                || k+1 < 5 && j-1 > -1 && array[i][j-1][k+1] == 'P' && (array[i][j][k+1] != 'X' || array[i][j-1][k] != 'X')
                                || k-1 > -1 && j-1 > -1 && array[i][j-1][k-1] == 'P' && (array[i][j][k-1] != 'X' || array[i][j-1][k] != 'X')
                        ){
                            isLineHave = true;
                            break;
                        }
                    }
                }

                if(isLineHave == true){
                    isRoomHave = true;
                    break;
                }
            }

            if(isRoomHave == true){
                answer[i] = 0;
            }
            else{
                answer[i] = 1;
            }
        }

        return answer;
    }
}

public class P03_03_71849_Practice {
    public static void main(String[] args) {
        String[][] places  = {
            {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"},
        };


        Solution s = new Solution();
        int[] result = s.solution(places);
        for(int i : result){
            System.out.print(i + " ");
        }

    }
}
