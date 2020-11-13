public class Judge {
	public int findJudge(int n, int[][] trust) {
		int temp = n;
		n= n+1;
		int [] incident = new int[n];
		for (int v =1; v < n; v++) {
			for (int w = 1; w < n; w++) {
				// System.out.println(trust[w][v] + " w is " + w + "v is " + v);
				incident[v] += trust[w][v];
			}
		}
		for (int i = 1; i < incident.length; i++) {
			// System.out.println(incident[i]);
			if(incident[i] == temp-1) {
				for(int t = 0; t < trust.length; t++) {
					if (trust[i][t] == 1) {
						return -1;
					}
				}
				return i;
			}
		}
		return -1;
	}
	public static void main (String[] args) {
		Judge s = new Judge();
		int[][] trust_test = {
			{1,3}, {1,4}, {2,3}, {2,4}, {4,3}
		};
		int total_people = 4;

		int[][] adjacencyMatrix = new int[1000][1000];
		for(int i = 0; i < trust_test.length; i++) {
			adjacencyMatrix[trust_test[i][0]][trust_test[i][1]] = 1;
		}
		System.out.println(s.findJudge(total_people, adjacencyMatrix));

	}
}