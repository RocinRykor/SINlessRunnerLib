package studio.rrprojects.srl.generators;

import java.security.SecureRandom;
import java.util.Base64;

public class MatrixHostGenerator {
    public String MatrixAccessProtocolBuilder() {
        String MATRIX_ACCESS_PROTOCOL = "map";
        String GRID = "Ares";

        String randomBase64 = generateRandomBase64(6);
        String formattedBase64 = formatBase64(randomBase64);

        String output = String.format("%s://%s:%s",
                MATRIX_ACCESS_PROTOCOL, GRID, formattedBase64);

        return output;
    }

    public static String generateRandomBase64(int length) {
        boolean isValid = false;
        String output = "";

        while (!isValid) {
            byte[] randomBytes = new byte[length];
            new SecureRandom().nextBytes(randomBytes);
            output = Base64.getEncoder().encodeToString(randomBytes);
            if (!output.contains("+") && !output.contains("/")) {
                isValid = true;
            }
        }

//        System.out.println("BASE64: " + output);
        return output;
    }

    public static String formatBase64(String base64String) {
        StringBuilder formattedString = new StringBuilder();
        for (int i = 0; i < base64String.length(); i += 2) {
            formattedString.append(base64String.substring(i, Math.min(i + 2, base64String.length())));
            if (i + 2 < base64String.length()) {
                formattedString.append(":");
            }
        }
        return formattedString.toString();
    }

}
