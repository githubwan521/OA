import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Restriction {
    private static final String ERROR = "error";
    private static final String QUALIFIED = "qualified";
    private static final String EMPTY = "";

    public static String answer(String str, int time) {
        List<String> licensePlates = Arrays.asList(str.split(","));

        if (ERROR.equals(Check(licensePlates))) {
            return ERROR;
        }
        StringBuffer stringBuffer = new StringBuffer();
        licensePlates.stream().forEach(
                o -> {
                    for (int i = o.length() - 1; i >= 0; i--) {
                        if (Character.isDigit(o.charAt(i))) {
                            if (time == Integer.valueOf(String.valueOf(o.charAt(i))) % 5) {
                                stringBuffer.append(o + ",");
                            }
                            break;
                        }
                    }
                }
        );

        return stringBuffer.length() > 0 ?
                stringBuffer.substring(0, stringBuffer.length() - 1) :
                EMPTY;

    }

    public static String Check(List<String> licensePlates) {
        for (String str : licensePlates) {
            if (str.length() < 5) {
                return ERROR;
            }
            int letter = 0;
            for (int i = 0; i < 5; i++) {
                if (Character.isDigit(str.charAt(i))) {
                    break;
                } else if (Character.isLetter(str.charAt(i))) {
                    letter++;
                } else {
                    return ERROR;
                }
            }
            if (5 == letter) {
                return ERROR;
            }
        }

        return QUALIFIED;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();// 车牌号
        int time = sc.nextInt();// 时间
        System.out.print(answer(str, time));
    }

}
