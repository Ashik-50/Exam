import java.util.*;
class Diffiehellman {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of p : ");
        int p=sc.nextInt();
        System.out.println("Enter the primitive root of p : ");
        int g=sc.nextInt();
        System.out.println("Enter the private key of A : ");
        int a=sc.nextInt();
        System.out.println("Enter the private key of B : ");
        int b=sc.nextInt();
        int A=(int)Math.pow(g,a)%p;
        int B=(int)Math.pow(g,b)%p;
        int s=(int)Math.pow(B,a)%p;
        System.out.println("The public key of A : "+A);
        System.out.println("The public key of B : "+B);
        System.out.println("The shared secret key is : "+s);
    }
}