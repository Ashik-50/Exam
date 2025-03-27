import javax.crypto.*;
import java.util.*;
class DES{
    public static void main(String[] args){
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the Plain text : ");
            String text=sc.nextLine();
            SecretKey key=KeyGenerator.getInstance("DES").generateKey();
            Cipher c=Cipher.getInstance("DES");
            c.init(Cipher.ENCRYPT_MODE,key);
            String enc=Base64.getEncoder().encodeToString(c.doFinal(text.getBytes()));
            System.out.println("Encrypted string : "+enc);
            c.init(Cipher.DECRYPT_MODE,key);
            String dec=new String(c.doFinal(Base64.getDecoder().decode(enc)));
            System.out.println("Decrypted string : "+dec);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}