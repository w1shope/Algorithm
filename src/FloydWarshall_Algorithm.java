public class FloydWarshall_Algorithm {
    static final int NUMBER = 10; // 자역 개수
    static final int MAX_NUM = Integer.MAX_VALUE; // 최대 값
    static final String[] locations = {"서울", "천안", "원주", "강릉", "논산", "대전", "대구", "포항", "광주", "부산"}; // 지역 정보
    // 양방향 간선 정보
    static int[][] local = {
            {0, 12, 15, MAX_NUM, MAX_NUM, MAX_NUM, MAX_NUM, MAX_NUM, MAX_NUM, MAX_NUM},
            {12, 0, MAX_NUM, MAX_NUM, 4, 10, MAX_NUM, MAX_NUM, MAX_NUM, MAX_NUM},
            {15, MAX_NUM, 0, 21, MAX_NUM, MAX_NUM, 7, MAX_NUM, MAX_NUM, MAX_NUM},
            {MAX_NUM, MAX_NUM, 21, 0, MAX_NUM, MAX_NUM, MAX_NUM, 25, MAX_NUM, MAX_NUM},
            {MAX_NUM, 4, MAX_NUM, MAX_NUM, 0, 3, MAX_NUM, MAX_NUM, 13, MAX_NUM},
            {MAX_NUM, 10, MAX_NUM, MAX_NUM, 3, 0, 10, MAX_NUM, MAX_NUM, MAX_NUM},
            {MAX_NUM, MAX_NUM, 7, MAX_NUM, MAX_NUM, 10, 0, 19, MAX_NUM, 9},
            {MAX_NUM, MAX_NUM, MAX_NUM, 25, MAX_NUM, MAX_NUM, 19, 0, MAX_NUM, 5},
            {MAX_NUM, MAX_NUM, MAX_NUM, MAX_NUM, 13, MAX_NUM, MAX_NUM, MAX_NUM, 0, 15},
            {MAX_NUM, MAX_NUM, MAX_NUM, MAX_NUM, MAX_NUM, MAX_NUM, 9, 5, 15, 0}
    };

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        // node : 거쳐 갈 노드
        for (int node = 0; node < NUMBER; node++) {
            // i : 시작 노드
            for (int i = 0; i < NUMBER; i++) {
                // j : 도착 노드
                for (int j = 0; j < NUMBER; j++) {
                    int distance = local[i][node] + local[node][j];
                    // i->j거리와 i -> node -> j 거리를 비교해서 더 짧은 거리를 저장
                    if (distance >= 0 && distance < local[i][j])
                        local[i][j] = distance;
                }
            }
        }

        for (int i = 0; i < NUMBER; i++)
            System.out.println(locations[i] + ": " + local[i][0]);
    }
}