package encryptdecrypt;

public class Main {
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        String decider = sc.nextLine();
        String input = sc.nextLine();
        int key = sc.nextInt();

        StringBuilder sb = new StringBuilder(input);

        sb = "enc".equals(decider) ? encrypt(sb, key) : decrypt(sb, key);

        System.out.println(sb);
    }

    static StringBuilder encrypt(StringBuilder sb, int key) {

        for (int i = 0; i < sb.length(); i++) {

            char c = (char) (sb.charAt(i) + key);
            sb.replace(i, i + 1, String.valueOf(c));
        }
        return sb;
    }

    static StringBuilder decrypt(StringBuilder sb, int key) {

        for (int i = 0; i < sb.length(); i++) {

            char c = (char) (sb.charAt(i) - key);
            sb.replace(i, i + 1, String.valueOf(c));
        }
        return sb;
    }
}
