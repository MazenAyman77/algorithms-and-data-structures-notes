package twoPointers.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums){

        List<List<Integer>> result = new ArrayList<>();
        // sorting the array
        Arrays.sort(nums);

        // here we start from 0 and we stop 3 elements from the end because we need at least three numbers to form a triplet
        for(int i = 0; i < nums.length - 2; i++){

            // here we say that if the number we have is equal to the number we have just processed we skip
            // this prevent to generate the exact same triplets we have just generated
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i+1; // left pointer
            int right = nums.length -1; // right pointer

            while(left < right){

                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // here to remove duplicates we say if we found the sum is 0 we shift to the other number in the array
                    // and it should not be the same as the already chosen
                    while(left < right && nums[left] == nums[left + 1]){left ++;}
                    while(left < right && nums[right] == nums[right - 1]){right --;}
                    left++;
                    right--;
                }
                // if the sum is greater than 0 so we need to shift the right pointer to the left
                else if(sum > 0){
                    right--;
                }
                // if the sum is smaller than 0 so we need to shift the left pointer to the right
                else{
                    left++;
                }
            }
        }
        return result;
    }

}