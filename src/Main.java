public class Main {
    public static void main(String[] args) {
        /**
         * @문제
         * 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다.
         * 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고,
         * 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때
         * 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
         * 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
         * 컴퓨터의 개수 n,
         * 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때,
         * 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
         * @제한사항
         * 컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
         * 각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
         * i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
         * computer[i][i]는 항상 1입니다.
         * @입출력예
         * n    computers	                        return
         * 3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
         * 3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
         * --------------------------------------------------------------------
         * computers[0][0] = 1
         * computers[0][1] = 1
         * computers[0][2] = 0
         * computers[1][0] = 1
         * computers[1][1] = 1
         * computers[1][2] = 0
         *
         * dfs 로 탐색이 끝이나면 1개의 네트워크
         * 탐색을 하면서 탐색이 된 노드는 알고 있으니,
         * 그 중 탐색이 안된 노드를 첫 노드로 시작하여 dfs 시작
         * --------------------------------------------------------------------
         */
        Solution solution = new Solution();
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int networkNum = solution.solution(3, computers);
        System.out.printf("%d", networkNum);
    }
}


class Solution {
    public int solution(int n, int[][] computers) {
        int networkNum = 0;
        boolean[] computersInNetwork = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!computersInNetwork[i]) {
                dfs(computers, computersInNetwork, i);
                networkNum++;
            }
        }
        return networkNum;
    }

    void dfs(int [][] computers, boolean[] computersInNetwork, int index) {
        computersInNetwork[index] = true;
        for(int i = 0; i < computers[index].length; i++) {
            if(computers[index][i] == 1 && !computersInNetwork[i]) {
                dfs(computers, computersInNetwork, i);
            }
        }
    }
}