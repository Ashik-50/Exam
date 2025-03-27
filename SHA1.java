import java.security.MessageDigest;
import java.util.Scanner;
class SHA1 {
    public static void main(String[] args){
        try{
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter the string : ");
            String str=sc.nextLine();
            MessageDigest md=MessageDigest.getInstance("SHA-1");
            byte[] digest=md.digest(str.getBytes());
            StringBuilder sb=new StringBuilder();
            for(byte b:digest){
                sb.append(String.format("%02x",b));
            }
            System.out.println("SHA-1 Hash : "+sb.toString());
        }
        catch(Exception e){
            System.out.println(e); 
        }
    }
}