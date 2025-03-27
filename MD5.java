import java.util.*;
import java.security.MessageDigest;
class MD5 {
    public static void main(String[] args){
        try{
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter the string : ");
            String text=sc.nextLine();
            MessageDigest md=MessageDigest.getInstance("MD5");
            byte[] digest=md.digest(text.getBytes());
            StringBuilder sb=new StringBuilder();
            for(byte b:digest){
                sb.append(String.format("%02x",b));
            }
            System.out.println("MD5 Hash : "+sb.toString());
        }catch(Exception e){
            System.out.println(e);
        }
    }
}