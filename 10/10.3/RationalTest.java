import java.util.Scanner;

public class RationalTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Rational result = new Rational(sc.nextInt(), sc.nextInt());
        char operation = sc.next().charAt(0);
        while (operation != '.') {
            Rational nextR = new Rational(sc.nextInt(), sc.nextInt());
            switch(operation) {
                case '+': result = result.add(nextR); break;
                case '-': result = result.sub(nextR); break;
                case '*': result = result.mul(nextR); break;
                case '/': result = result.div(nextR); break;
            }

            operation = sc.next().charAt(0);
        }

        System.out.println(result.toString());
    }
}
