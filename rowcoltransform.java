import java.util.*;
class rowcoltransform {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string : ");
        String text = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "");
        System.out.println("Enter the rows : ");
        int rows = sc.nextInt();
        System.out.println("Enter the columns : ");
        int cols = sc.nextInt();
        System.out.println("Encrypted text : "+encrypt(text,rows,cols));
        System.out.println("Decrypted text : "+decrypt(encrypt(text,rows,cols),rows,cols));
    }
    public static String encrypt(String text,int rows,int cols){
        char[][] mat = new char[rows][cols];
        int k=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(k<text.length()){
                    mat[i][j]=text.charAt(k++);
                }else{
                    mat[i][j]='X';
                }
            }
        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                res.append(mat[j][i]);
            }
        }
        return res.toString();
    }
    public static String decrypt(String text,int rows,int cols){
        char[][] mat = new char[rows][cols];
        int k=0;
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                mat[j][i]=text.charAt(k++);
            }
        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                res.append(mat[i][j]);
            }
        }
        return res.toString();
    }
}
