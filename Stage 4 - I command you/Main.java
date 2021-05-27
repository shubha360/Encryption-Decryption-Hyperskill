package encryptdecrypt;

public class Main {
    public static void main(String[] args) {

        String mode = "enc";
        int key = 0;
        StringBuilder data = new StringBuilder("");

        for (int i = 0; i < args.length; i++) {

            switch (args[i]) {

                case "-mode" :
                    mode = args[i + 1];
                    i += 1;
                    break;

                case "-key" :
                    key = Integer.valueOf(args[i + 1]);
                    i += 1;
                    break;

                case "-data" :
                    data.append(args[i + 1]);
                    i += 1;
                    break;
            }
        }

        if ("enc".equals(mode)) {
            encrypt(data, key);
        } else {
            decrypt(data, key);
        }

        System.out.println(data);
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
