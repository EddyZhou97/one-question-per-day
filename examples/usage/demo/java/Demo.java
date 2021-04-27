package demo.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhouYi
 * 2021/4/2 8:21 下午
 */
public class Demo {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{2, 1, 7, 0, -3, -4}));
        System.out.println(mergeArray(new int[]{1, 2, 4}, new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(mergeArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, new int[]{1, 2, 4}));
        System.out.println(mergeArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }

    public static List<List<Integer>> solution(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {

            int twoSum = -arr[i];
            int start = i + 1;
            int last = arr.length - 1;

            while (start < last) {
                int lastOne = twoSum - arr[start];

                if (arr[last] == lastOne) {
                    List<Integer> res = new ArrayList<>();
                    res.add(arr[i]);
                    res.add(arr[start]);
                    res.add(arr[last]);
                    result.add(res);
                    start++;
                    last--;

                } else if (arr[last] > lastOne) {
                    last--;
                } else {
                    start++;
                }

            }

        }
        return result;
    }

    public static List<Integer> mergeArray(int[] arr1, int[] arr2) {

        int tmpOne = arr1[0];
        int tmpTwo = arr2[0];
        int arr1Index = 0;
        int arr2Index = 0;

        List<Integer> mergedArray = new ArrayList<>();

        int breakTag = 0;

        while (breakTag < 1) {
            if (tmpOne < tmpTwo) {
                if (arr1Index < arr1.length) {
                    mergedArray.add(tmpOne);
                    arr1Index += 1;
                    if (arr1Index == arr1.length) {
                        breakTag++;
                    } else {
                        tmpOne = arr1[arr1Index];
                    }
                }
            } else {
                if (arr2Index < arr2.length) {
                    mergedArray.add(tmpTwo);
                    arr2Index += 1;
                    if (arr2Index == arr2.length) {
                        breakTag++;
                    } else {
                        tmpTwo = arr2[arr2Index];
                    }
                }
            }
        }

        if (arr1Index == arr1.length) {
            while (arr2Index < arr2.length) {
                mergedArray.add(arr2[arr2Index++]);
            }
        } else {
            while (arr1Index < arr1.length) {
                mergedArray.add(arr1[arr1Index++]);
            }
        }
        return mergedArray;
    }
}
