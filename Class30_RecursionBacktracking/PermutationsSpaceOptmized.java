import java.util.Scanner;

public class PermutationsSpaceOptmized{

    public static void swap(char[] charArr, int i, int j){
        char temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;
    }

    public static void permute(char[] chArr, int i){
        if(i == chArr.length){
            System.out.println(chArr);
            return;
        }


        for(int j=i; j<chArr.length; j++){
            swap(chArr, i, j);    // Self Work      // abc,1,2 -> acb
            permute(chArr, i+1);
            swap(chArr, i, j);    // Backtracking   // acb,1,2 -> abc
        }
    }

    public static void permute(String str){
        permute(str.toCharArray(), 0);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        System.out.println("All Permutations of " + str + " are: ");
        permute(str);
    }
    
}