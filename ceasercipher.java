import java.util.*;
class ceaser{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string : ");
        String str=sc.nextLine();
        System.out.println("Enter the key : ");
        int key=sc.nextInt();
        String res=encrypt(str,key);
        System.out.println("Encrypted string : "+res);
        System.out.println("Decrypted string : "+encrypt(res,26-key));
    }
    public static String encrypt(String str,int key){
        String res="";
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(Character.isUpperCase(ch)){
                res+=((char)((ch+key-'A')%26+'A'));
            }else if(Character.isLowerCase(ch)){
                res+=((char)((ch+key-'a')%26+'a'));
            }else{
                res+=ch;
            }
        }
        return res;
    }
    public static String decrypt(String str,int key){
        return encrypt(str,26-key);
    }
}