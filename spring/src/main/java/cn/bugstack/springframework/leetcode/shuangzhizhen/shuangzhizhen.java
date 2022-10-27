package cn.bugstack.springframework.leetcode.shuangzhizhen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Auther: 李清依
 * @Date: 2022/9/23 12:37
 * @Description:
 */
public class shuangzhizhen {
    public int[] twoSum(int[] numbers, int target) {
        int arr[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                arr[0] = map.get(map.get(target - numbers[i]));
                arr[1] = i;
            } else {
                map.put(numbers[i], i);
            }
        }
        return arr;
    }

    public boolean judgeSquareSum(int target) {
        if (target < 0) return false;
        int i = 0, j = (int) Math.sqrt(target);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == target) {
                return true;
            } else if (powSum > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public String reverseVowels(String s) {
        HashSet<Character> objects = new HashSet<>();
        char cc[] = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (char c :
                cc) {
            objects.add(c);
        }
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i <= j) {
            if (!objects.contains(chars[i])) {
                i++;
            } else if (!objects.contains(chars[j])) {
                j--;
            } else {
                char t = chars[i];
                chars[i] = chars[j];
                chars[j] = t;
                i++;
                j--;
            }
        }
        return new String(chars);
    }

    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length;
        while (i < j) {
            if (chars[i] != chars[j]) {
                return ishuiwen(chars,i+1,j)||ishuiwen(chars,i,j-1);
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean ishuiwen(char[] arr, int i, int j) {

        while (i < j) {
            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;
        int nums3[]=new int[m+n];
        int k=0;
        while (i<m||j<n){
            if (nums1[i]>=nums2[j]){
                nums3[k++]=nums1[i];
                i++;
            }else {
                nums3[k++]=nums2[j];
                j++;
            }
        }
        if (i<m){
            while (i<m){
                nums3[k++]=nums1[i];
            }
        }
        if (j<n){
            while (j<n){
                nums3[k++]=nums2[j];
            }
        }
        int y=0;
        for (int x:nums3
             ) {
            nums1[y]=x;
        }
    }

}
