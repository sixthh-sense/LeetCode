package HaeInSung.LearningCurve.dailyCT.August2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/* Path with Maximum Probability */
public class DQ_1514 {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        for (int i = 0; i < n - 1; i++) {
            boolean hasUpdate = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double pathProb = succProb[j];
                if (maxProb[u] * pathProb > maxProb[v]) {
                    maxProb[v] = maxProb[u] * pathProb;
                    hasUpdate = true;
                }
                if (maxProb[v] * pathProb > maxProb[u]) {
                    maxProb[u] = maxProb[v] * pathProb;
                    hasUpdate = true;
                }
            }
            if (!hasUpdate) {
                break;
            }
        }

        return maxProb[end];
    }

    public static void main(String[] args) {

        DQ_1514 dq = new DQ_1514();

        List<Integer> graphList = new ArrayList<>(List.of(3, 3, 3));
        List<int[][]> edgeList = new ArrayList<>();
        edgeList.add(new int[][]{{0, 1}, {1, 2}, {0, 2}});
        edgeList.add(new int[][]{{0, 1}, {1, 2}, {0, 2}});
        edgeList.add(new int[][]{{0, 1}});

        List<double[]> succProbList = new ArrayList<>();
        succProbList.add(new double[]{0.5,0.5,0.2});
        succProbList.add(new double[]{0.5,0.5,0.3});
        succProbList.add(new double[]{0.5});

        List<Integer> startList = new ArrayList<>(List.of(0, 0, 0));
        List<Integer> endList = new ArrayList<>(List.of(2, 2, 2));

        for (Integer graph : graphList) {
            int index = graphList.indexOf(graph);
            System.out.println(dq.maxProbability(graph, edgeList.get(index), succProbList.get(index), startList.get(index), endList.get(index)));
        }
    }
}
