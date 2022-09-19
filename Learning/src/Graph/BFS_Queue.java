package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_Queue {
	static int[][] graph = { {}, { 2, 3, 8 }, { 1, 6, 8 }, { 1, 5 }, { 5, 7 }, { 3, 4, 7 }, { 2 }, { 4, 5 }, { 1, 2 } };
	static boolean[] visited = new boolean[9];

	public static void main(String[] args) {
		System.out.println(bfs(1, graph, visited));
	}// end of main

	static String bfs(int start, int[][] graph, boolean[] visited) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);// 시작 노드 추가
		visited[start] = true;

		while (!q.isEmpty()) {
			int nodeIndex = q.poll();
			sb.append(nodeIndex + "->");
			for (int i = 0; i < graph[nodeIndex].length; i++) {
				int tmp = graph[nodeIndex][i];
				if (!visited[tmp]) {
					visited[tmp] = true;
					q.offer(tmp);
				}
			}
		}
		return sb.toString();
	}
}// end of class