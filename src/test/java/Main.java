import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/27 14:20
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        ArrayList<HashSet<Integer>> setList = new ArrayList<HashSet<Integer>>();
        ArrayList<HashSet<Integer>> resList = new ArrayList<HashSet<Integer>>();

        for (int i = 0; i < N; i++) {
            String str = input.next();
            String[] strings = str.split(" ");
            System.out.println(Arrays.toString(strings));
            for (int j = 0; j < strings.length; j++) {
//                setList.get(i).add(Integer.valueOf(strings[j]));
            }
        }
        setList.sort(Comparator.comparingInt(Set::size));

        while (setList.size() > 1) {
            setList.sort(Comparator.comparingInt(Set::size));

            boolean flag = true;
            Set<Integer> tem = new HashSet<>(setList.get(0));
            for (int i = 1; i < setList.size(); i++) {
                tem.retainAll(setList.get(i));
                if (tem.size() > 0) {
                    setList.get(0).addAll(setList.get(i));
                    setList.remove(i);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                setList.remove(0);
            }
        }
        System.out.println(setList.get(setList.size()-1).size());

    }
}
