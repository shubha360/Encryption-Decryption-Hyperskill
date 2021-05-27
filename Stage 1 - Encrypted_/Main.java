package encryptdecrypt;

public class Main {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("we found a treasure!");

        sb = encrypt(sb);

        System.out.println(sb);
    }

    static StringBuilder encrypt(StringBuilder sb) {

        for (int i = 0; i < sb.length(); i++) {

            if (sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z') {

                sb.replace(i,i+1, String.valueOf((char) ('z' - sb.charAt(i) + 'a')));
            }
        }
        return sb;
    }
}
