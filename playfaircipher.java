import java.util.*;
class playfaircipher {
    public static char matrix[][]=new char[5][5];
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Plain text : ");
        String text = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        System.out.println("Enter the key : ");
        String key = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        generatematrix(key);
        String res=encrypt(text);
        System.out.println("Encrypted string : "+res);
    }
    public static void generatematrix(String key){
        StringBuilder k=new StringBuilder(key);
        for(char c='A';c<='Z';c++){
            if(c!='J'&&k.indexOf(String.valueOf(c))==-1){
                k.append(c);
            }
        }
        int idx=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                matrix[i][j]=k.charAt(idx++);
            }
        }
    }
    public static String encrypt(String text){
        StringBuilder p=new StringBuilder(),r=new StringBuilder();
        for(int i=0;i<text.length();i++){
            p.append(text.charAt(i));
            if(i+1<text.length()&&text.charAt(i)==text.charAt(i+1)){
                p.append('X');
            }
        }
        if(p.length()%2!=0) p.append('X');
        for(int i=0;i<p.length();i+=2){
            char a=p.charAt(i),b=p.charAt(i+1);
            int []p1=findpos(a),p2=findpos(b);
            if(p1[0]==p2[0]){
                r.append(matrix[p1[0]][(p1[1]+1)%5]);
                r.append(matrix[p2[0]][(p2[1]+1)%5]);
            }else if(p1[1]==p2[1]){
                r.append(matrix[(p1[0]+1)%5][p1[1]]);
                r.append(matrix[(p2[0]+1)%5][p2[1]]);
            }else{
                r.append(matrix[p1[0]][p2[1]]);
                r.append(matrix[p2[0]][p1[1]]);
            }
        }
        return r.toString();
    }
    public static int[] findpos(char ch){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(matrix[i][j]==ch){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
