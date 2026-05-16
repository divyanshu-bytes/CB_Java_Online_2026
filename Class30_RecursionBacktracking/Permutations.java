import java.util.Scanner;

public class Permutations{

    public static String swap(String str, int i, int j){
        char[] charArr = str.toCharArray();     // char[] -> Mutable 
        char temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;

        return String.valueOf(charArr);
    }

    public static void permute(String str, int i){
        if(i == str.length()){
            System.out.println(str);
            return;
        }


        for(int j=i; j<str.length(); j++){
            str = swap(str, i, j);    // Self Work
            permute(str, i+1);
        }
    }

    public static void permute(String str){
        permute(str, 0);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        System.out.println("All Permutations of " + str + " are: ");
        permute(str);
    }
    
}