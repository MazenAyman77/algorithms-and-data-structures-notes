package arrays.easy;

import java.util.HashSet;
import java.util.Set;

//Description :
//Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

public class ContainsDuplicate {
    public boolean solve(int[] array){

        boolean flag = false;
        Set<Integer> set = new HashSet<>();
        for (int element : array) {
            if(!set.contains(element)){
                set.add(element);
            }
            else{
                flag = true;
            }
        }
        return flag;
    }
}
