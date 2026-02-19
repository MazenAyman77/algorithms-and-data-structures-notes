package arrays.easy;

import java.util.HashMap;
import java.util.Map;

//Description:
//Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
//
//You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
//
//Return the answer with the smaller index first.

public class TwoSum {

    public int[] solve(int[] nums, int target){

        // Map has its key as the value inside the nums, and its value as the index
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){

            int complemient = target - nums[i];
            if(map.containsKey(complemient) && map.get(complemient) != i){
                return new int[]{map.get(complemient), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
