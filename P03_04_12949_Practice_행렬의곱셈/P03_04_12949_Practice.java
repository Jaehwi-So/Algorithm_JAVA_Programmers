package P03_04_12949_Practice_행렬의곱셈;


class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];  //[[15, 15], [15, 15], [15, 15]]
        for(int i = 0; i < arr1.length; i++){ //3
            for(int j = 0; j < arr2[0].length; j++){ //4
                int sum = 0;
                for(int k = 0; k < arr2.length; k++){ //2
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;


            }
        }

        return answer;
    }
}

public class P03_04_12949_Practice {
    public static void main(String[] args) {
        int[][] arr1 = {{1,4}, {3,2}, {4,1}};   // 3 * 2
        int[][] arr2 = {{3,3}, {3,3}};  // 2 * 2

        Solution s = new Solution();
        int[][] result = s.solution(arr1, arr2);
        for(int[] i : result){
            for(int j : i)
            System.out.print(j + " ");
        }

    }
}
