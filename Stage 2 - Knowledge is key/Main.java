package encryptdecrypt;

public class Main {
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        String st = sc.nextLine();
        int key = sc.nextInt();

        StringBuilder sb = new StringBuilder(st);

        sb = encrypt(sb, key);

        System.out.println(sb);
    }

    static StringBuilder encrypt(StringBuilder sb, int key) {

        for (int i = 0; i < sb.length(); i++) {

            if (sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z') {

                char c = (char) ((sb.charAt(i) + key) % 122);

                if (c < 'a') {
                    c += 96;
                }
                sb.replace(i, i + 1, String.valueOf(c));
            }
        }
        return sb;
    }
}
