import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters{

	public static int lengthOfLongestSubstringWithoutRepeatingCharacters(String s) {
        int longestNonRep = 0;
        Set<Character> curWindowCharSet = new HashSet<>();
        int left = 0, right = 0;

        int n = s.length();
        while(right < n){
            if(curWindowCharSet.contains(s.charAt(right))){
                curWindowCharSet.remove(s.charAt(left));
                left++;
            }
            else{
                curWindowCharSet.add(s.charAt(right));
                right++;
                longestNonRep = Math.max(longestNonRep, curWindowCharSet.size());
            }
        }

        return longestNonRep;
    }

    public static String longestSubstringWithoutRepeatingCharacters(String s) {
        int longestNonRep = 0;
        Set<Character> curWindowCharSet = new HashSet<>();
        int left = 0, right = 0;
        int startAns = 0, endAns = 0;

        int n = s.length();
        while(right < n){
            if(curWindowCharSet.contains(s.charAt(right))){
                curWindowCharSet.remove(s.charAt(left));
                left++;
            }
            else{
                curWindowCharSet.add(s.charAt(right));
                right++;
                if(curWindowCharSet.size() > longestNonRep){
                	startAns = left;
                	endAns = right;
                	longestNonRep = curWindowCharSet.size();
                }
            }
        }

        return s.substring(startAns, endAns);
    }

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();

		System.out.println("Longest Substring without Repeteating Characters Length = " + lengthOfLongestSubstringWithoutRepeatingCharacters(str));
		System.out.println("Longest Substring without Repeteating Characters Length = " + longestSubstringWithoutRepeatingCharacters(str));
	}
}