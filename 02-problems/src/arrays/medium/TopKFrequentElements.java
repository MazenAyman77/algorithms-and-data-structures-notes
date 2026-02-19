package arrays.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static int[] solve(int[] array, int k){

        // map its key is the number in the array, and its value is the count of that number in the array
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : array) {

            // here we add the integers with their frequencies
            map.put(i, map.getOrDefault(i,0)+1);
        }

        // making a min heap so we can compare the numbers in our map, and the number with the least frequency will be at
        // the top of the heap i.e. making a comparator.
        // here if the result is negative then a is the least frequent and it gets at the top
        // if the result is positive then b is the least frequent
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );

        // adding the numbers in the heap
        for(int num : map.keySet()){

            minHeap.add(num);
            if(minHeap.size() > k){
                // remove the least frequent
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = minHeap.poll();
        }
        return result;
    }

}