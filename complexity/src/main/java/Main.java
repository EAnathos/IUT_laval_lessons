public class Main {
    public static void main(String[] args) {
        System.out.println(totalSum(5));
    }

    private static long totalSum(long nb) {
        long result = 0;
        for (long i = 0; i < nb; i++) {
            result += i;
        }
        return result;
    }
}