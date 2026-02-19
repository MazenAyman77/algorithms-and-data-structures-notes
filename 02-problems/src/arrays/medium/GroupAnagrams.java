package arrays.medium;

import java.util.*;

//Description
//Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
//An anagram is a string that contains the exact same characters as another string,
//but the order of the characters can be different.

public class GroupAnagrams {

    public static List<List<String>> solve(String[] array){

        Map<String, List<String>> map = new HashMap<>();

        for (String s : array) {

            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            if (!map.containsKey(String.valueOf(temp))) {

                map.put(String.valueOf(temp), new ArrayList<>());
            }
            map.get(String.valueOf(temp)).add(s);
        }
        return new ArrayList<>(map.values());
    }



    public static void main(String[] args) {

        String[] array = new String[]{"act","pots","tops","cat","stop","hat"};
        List<List<String>> finalSet = solve(array);
        System.out.println(finalSet);
    }

}
