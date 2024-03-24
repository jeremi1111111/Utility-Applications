package Problem221;

public class Sevenish {
    public static int sevenish(int number) {
        int current = 1;
        int iteration = 1;
        while (current < number) {
            iteration += 1;
            current += iteration;
        }
        current -= iteration;
        int result = (int)Math.pow(7, iteration - 1);
        int add = 1;
        for (int i = 0; i < number - current - 1; i++) {
            result += add;
            add *= 7;
        }
        return result;
    }
}
