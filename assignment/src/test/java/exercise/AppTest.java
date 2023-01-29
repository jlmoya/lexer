package exercise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    @DisplayName("Should return an empty set when the two arrays are empty")
    void intersectionWhenTwoArraysAreEmptyThenReturnEmptySet() {
        App app = new App();
        int[] nums1 = {};
        int[] nums2 = {};
        HashSet<Integer> expected = new HashSet<Integer>();
        HashSet<Integer> actual = app.intersection(nums1, nums2);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should return an empty set when the first array is empty")
    void intersectionWhenFirstArrayIsEmptyThenReturnEmptySet() {
        App app = new App();
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3};
        HashSet<Integer> expected = new HashSet<Integer>();
        HashSet<Integer> actual = app.intersection(nums1, nums2);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName(
        "Should return a set with two elements when the two arrays have two elements in common")
    void intersectionWhenTwoArraysHaveTwoElementsInCommonThenReturnASetWithTwoElements() {
        App app = new App();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        HashSet<Integer> expected = new HashSet<Integer>();
        expected.add(2);
        HashSet<Integer> actual = app.intersection(nums1, nums2);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should return an empty set when the second array is empty")
    void intersectionWhenSecondArrayIsEmptyThenReturnEmptySet() {
        App app = new App();
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {};
        HashSet<Integer> expected = new HashSet<Integer>();
        HashSet<Integer> actual = app.intersection(nums1, nums2);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName(
        "Should return a set with one element when the two arrays have one element in common")
    void intersectionWhenTwoArraysHaveOneElementInCommonThenReturnASetWithOneElement() {
        int[] nums1 = {1,2};
        int[] nums2 = {2};
        App app = new App();

        HashSet<Integer> result = app.intersection(nums1, nums2);

        assertEquals(1, result.size());
    }
}
