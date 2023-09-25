package P03_03_71849_Practice_Fix_거리두기확인하기;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        char[][][] array = new char[5][9][9];
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                array[i][j] = new char[]{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'};
                if (!(j < 2 || j > 6)) {
                    char[] line = places[i][j - 2].toCharArray();
                    System.arraycopy(line, 0, array[i][j], 2, 5);
                }

            }
        }
        for(int i = 0; i < 5; i++){

            roomLoop : for(int j = 2; j < 7; j++){
                for(int k = 2; k < 7; k++){
                    if(array[i][j][k] == 'P'){
                        //1차 상하좌우 체크
                        if(array[i][j][k+1] == 'P'
                                || array[i][j][k-1] == 'P'
                                || array[i][j+1][k] == 'P'
                                || array[i][j-1][k] == 'P'
                        ){
                            answer[i] = 0;
                            break roomLoop;
                        }

                        //2차 멘헤튼거리2 상하좌우 체크
                        if(array[i][j][k+2] == 'P' && array[i][j][k+1] != 'X'
                                || array[i][j][k-2] == 'P' && array[i][j][k-1] != 'X'
                                || array[i][j+2][k] == 'P' && array[i][j+1][k] != 'X'
                                || array[i][j-2][k] == 'P' && array[i][j-1][k] != 'X'
                        ){
                            answer[i] = 0;
                            break roomLoop;
                        }

                        //3차 대각 체크
                        if(array[i][j+1][k+1] == 'P' && (array[i][j][k+1] != 'X' || array[i][j+1][k] != 'X')
                                || array[i][j+1][k-1] == 'P' && (array[i][j][k-1] != 'X' || array[i][j+1][k] != 'X')
                                || array[i][j-1][k+1] == 'P' && (array[i][j][k+1] != 'X' || array[i][j-1][k] != 'X')
                                || array[i][j-1][k-1] == 'P' && (array[i][j][k-1] != 'X' || array[i][j-1][k] != 'X')
                        ){
                            answer[i] = 0;
                            break roomLoop;
                        }
                    }
                }
                answer[i] = 1;
            }

        }

        return answer;
    }
}

public class P03_03_71849_Practice_Fix {
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
