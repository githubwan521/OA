import java.util.Scanner;

public class Statistics {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String str = input.next();
        System.out.print(statistical(str));
    }


    public static Category statistical(String str) {
        Category character = new Category();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                character.digit++;
            } else if (Character.isLetter(str.charAt(i))) {
                character.letter++;
            } else if (Character.isWhitespace(str.charAt(i))) {
                character.whitespace++;
            } else {
                character.other++;
            }
        }
        return character;

    }
}

class Category {
    int letter;
    int whitespace;
    int digit;
    int other;

    public Category() {
    }

    public Category(int letter, int whitespace,
                    int digit, int other) {
        this.letter = letter;
        this.whitespace = whitespace;
        this.digit = digit;
        this.other = other;

    }

    @Override
    public String toString() {
        return "letter=" + letter + "\n" +
                "whitespace=" + whitespace + "\n" +
                "digit=" + digit + "\n" +
                "other=" + other + "\n";
    }


}
