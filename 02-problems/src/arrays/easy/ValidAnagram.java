package arrays.easy;

import java.util.Arrays;

//Description :
//Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
//An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

public class ValidAnagram {

    public boolean solve(String s, String t){

        if(s.length() != t.length()) return false;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        return Arrays.equals(ss, tt);
    }
}
