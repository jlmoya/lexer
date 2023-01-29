package exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 */
public class App {

    public static void main(String[] args) {
        App app = new App();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        HashSet<Integer> intersection = app.intersection(nums1, nums2);
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));
        System.out.println("Output: " + intersection);
        
        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        intersection = app.intersection(nums1, nums2);
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));
        System.out.println("Output: " + intersection);
    }

    /**
     * Given two arrays, write a function to compute the intersection of the two arrays.
     */
    public HashSet<Integer> intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> intersection = new HashSet<Integer>();

        Set<Integer> H = Arrays.stream(nums1).boxed().collect(Collectors.toSet());

        for (int i = 0; i < nums2.length; i++) {
            if (H.contains(nums2[i])) {
                intersection.add(nums2[i]);
            }
        }
        return intersection;
    }


}
