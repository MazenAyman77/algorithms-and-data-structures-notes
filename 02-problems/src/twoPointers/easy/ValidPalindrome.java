package twoPointers.easy;

public class ValidPalindrome {

    public boolean validPalindrome(String s) {

        int x = 0; // pointer from the left
        int y = s.length() - 1; // pointer from the right

        while(x < y){

            // checking if the pointer is referring to a char not a letter or a digit
            while(!Character.isLetterOrDigit(s.charAt(x)) && x < y){
                x++;
            }
            while(!Character.isLetterOrDigit(s.charAt(y)) && x < y){
                y--;
            }

            if(Character.toLowerCase(s.charAt(x)) != Character.toLowerCase(s.charAt(y))){
                return false;
            }
            x++;
            y--;
        }
        return true;
    }
}