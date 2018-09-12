import java.util.ArrayList;

public class Main {
    private static int max = Integer.MAX_VALUE;
    private static double[][] dist;
    private static int[][] path;
    private static ArrayList list = new ArrayList<Integer>();

    public static void findCheapestPath(int begin, int end, double Arcs[][]) {
        floyd(Arcs);
        list.clear();
        list.add(begin);
        findPath(begin, end);
        list.add(end);
    }

    public static void findPath(int i, int j) {
        int k = path[i][j];
        if (k == -1)
            return;
        findPath(i, k);
        list.add(k);
        findPath(k, j);
    }

    public static void floyd(double[][] Arcs) {
        int n = Arcs.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                path[i][j] = -1;                                              //初始化当前的路径长度表
                dist[i][j] = Arcs[i][j];                                  //初始化当前的路径表
            }

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != max && dist[k][j] != max && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = k;
                    }
                }
    }

    public static double Get(int N, int K, int[] X, int headx, int heady) {
        boolean[] visited = new boolean[N + 1];
        double[][] Arcs = new double[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    Arcs[i][j] = 0;
                } else {
                    Arcs[i][j] = Double.parseDouble(String.format("%.6f", (double) Math.abs(X[i] - X[j])));
                }
            }
        }
        for (int i = 0; i < N; i++) {
            double _x = Math.abs(headx - X[i]);
            double _y = Math.abs(heady - 0);
            double l = Double.parseDouble(String.format("%.6f", Math.sqrt(_x * _x + _y * _y)));
            Arcs[i][N] = l;
            Arcs[N][i] = l;
        }
        Arcs[N][N] = 0;
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                System.out.print(Arcs[i][j] + " ");
            }
            System.out.println();
        }
        //======================
        double min = 0;
        int count = 0;
        for (int i = 0; i < N + 1; i++) {
            visited[i] = true;
            double mintemp = Double.MAX_VALUE;
            for (int j = 0; j < N + 1; j++) {
                findCheapestPath(i, j, Arcs);
                ArrayList<Integer> L = list;
                System.out.println("路径长度:" + dist[i][j]);
                if (dist[i][j] < mintemp && !visited[j]) {
                    mintemp = dist[i][j];
                }
            }
            System.out.println("长度:" + i + ":  " + mintemp);
            min += mintemp;
            count++;
            System.out.println("==============" + min);
            if (count == N) {
                return min;
            }

        }
        return min;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] X = new int[]{1, 0, 2};
        dist = new double[4][4];
        path = new int[4][4];
        System.out.println(Double.parseDouble(String.format("%.6f", Get(3, 1, X, 1, 1))));
    }

}