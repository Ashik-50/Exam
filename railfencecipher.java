import java.util.*;
class railfencecipher {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Plain text : ");
        String text=sc.nextLine();
        System.out.println("Enter the key : ");
        int key=sc.nextInt();
        System.out.println("Encrypted string : "+encrypt(text,key));
        System.out.println("Decrypted string : "+decrypt(encrypt(text,key),key));
    }
    public static String encrypt(String text,int k){
        char[][] rail=new char[k][text.length()];
        for(int i=0;i<k;i++) Arrays.fill(rail[i],'\n');
        boolean down=false;
        int row=0,col=0;
        for(int i=0;i<text.length();i++){
            if(row==0||row==k-1) down=!down;
            rail[row][col++]=text.charAt(i);
            row=down?row+1:row-1;
        }
        StringBuilder result=new StringBuilder();
        for(int i=0;i<k;i++){
            for(int j=0;j<text.length();j++){
                if(rail[i][j]!='\n') result.append(rail[i][j]);
            }
        }
        return result.toString();
    }
    public static String decrypt(String text,int k){
        char[][] rail=new char[k][text.length()];
        for(int i=0;i<k;i++) Arrays.fill(rail[i],'\n');
        boolean down=false;
        int row=0,col=0;
        for(int i=0;i<text.length();i++){
            if(row==0||row==k-1) down=!down;
            rail[row][col++]='*';
            row=down?row+1:row-1;
        }
        int idx=0;
        for(int i=0;i<k;i++){
            for(int j=0;j<text.length();j++){
                if(rail[i][j]=='*') rail[i][j]=text.charAt(idx++);
            }
        }
        StringBuilder result=new StringBuilder();
        row=0;col=0;
        for(int i=0;i<text.length();i++){
            if(row==0) down=true;
            if(row==k-1) down=false;
            if(rail[row][col]!='\n') result.append(rail[row][col++]);
            row=down?row+1:row-1;
        }
        return result.toString();
    }
}