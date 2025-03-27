import java.security.*;
import java.util.Base64;
import java.util.Scanner;
class DigitalSignature {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the message: ");
        String message = scanner.nextLine();

        KeyPair keyPair = KeyPairGenerator.getInstance("DSA").generateKeyPair();
        Signature signature = Signature.getInstance("SHA256withDSA");

        signature.initSign(keyPair.getPrivate());
        signature.update(message.getBytes());
        byte[] signedMessage = signature.sign();
        System.out.println("Digital Signature: " + Base64.getEncoder().encodeToString(signedMessage));

        signature.initVerify(keyPair.getPublic());
        signature.update(message.getBytes());
        System.out.println("Signature verification result: " + signature.verify(signedMessage));
    }
}