package task1;

public class NumInSS {
    private int number;
    private int ss;

    public NumInSS(int number, int ss) {
        this.number = number;
        this.ss = ss;
    }

    public String convert() {
        String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();
        int num = number;
        while (num > 0) {
            int a = num % ss;
            result.insert(0, digits.charAt(a));
            num/=ss;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int number = 1032;
        int ss = 2;
        NumInSS converter = new NumInSS(number, ss);
        String convertedNumber = converter.convert();
        System.out.println("Результат перевода:"+convertedNumber);
    }
}
