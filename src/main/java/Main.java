import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Scanner;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/15 11:02
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = n + 1;

        Map<String, String> map = Maps.newHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }


        while (true) {
            long sumM = get_lcm_Num(1, n);
            long sumN = get_lcm_Num(n + 1, m);
            if (sumN % sumM == 0) {
                System.out.println(m);
                break;
            }
            m++;
        }
    }

    private static long get_lcm_Num(int n, int m) {
        long sum = 1;
        for (int i = n; i <= m; i++) {
            sum = getLcm(sum, i);
        }
        return sum;
    }


    private static long getGcd(long m, long n) {
        while (n > 0) {
            long temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }

    private static long getLcm(long m, long n) {
        long gcd = getGcd(m, n);
        return m * n / gcd;
    }
}