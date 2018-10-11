package mo.paradigm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/11
 */
public class Fruit {

    public static void main(String[] args) {
        List<? extends Fruit> list = new ArrayList<>();

        System.out.println(list);
    }
}
