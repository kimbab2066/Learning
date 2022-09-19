package Graph;

public class DFS_Recursion {
	static boolean[] visit = new boolean[10];
	static int[][] graph = { {}, { 2, 3, 8 }, { 1, 6, 8 }, { 1, 5 }, { 5, 7 }, { 3, 4, 7 }, { 2 }, { 4, 5 }, { 1, 2 } };

	public static void main(String[] args) {
		dfs(1);
	}// end of main

	static void dfs(int index) {
		visit[index] = true;// 방문 처리
		System.out.print(index + " -> ");// 방문 노드 출력
		for (int node : graph[index]) {// 인접 노드 찾기
			if (!visit[node])// 방문 X -> DFS
				dfs(node);
		}
	}// end of dfs
}// end of class