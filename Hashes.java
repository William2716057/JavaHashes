import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingExample {
    public static String hashSHA256(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(input.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = "MessageToBeHashed";
        String hashed = hashSHA256(input);
        System.out.println("Hashed value: " + hashed);
    }
}
