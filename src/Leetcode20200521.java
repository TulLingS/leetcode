import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 */
public class Leetcode20200521 {

    /**
     * 开辟新的空间存储，之后再赋值
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int x1 = 0; // nums1的指针
        int x2 = 0; // nums2的指针
        int[] nums = new int[m + n];

        int i = 0;
        while (x1 < m && x2 < n) {
            if (nums1[x1] <= nums2[x2]) {
                nums[i] = nums1[x1++];
            } else {
                nums[i] = nums2[x2++];
            }
            i++;
        }
        if (x1 < m) {
            for (int j = x1; j < m; j++) {
                nums[i++] = nums1[j];
            }
        }
        if (x2 < n) {
            for (int j = x2; j < n; j++) {
                nums[i++] = nums2[j];
            }
        }
        for (i = 0; i < nums.length; i++) {
            nums1[i] = nums[i];
        }
    }

    /**
     * 使用尾插法
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(String[] args) {
        int[] num1 = {1, 7, 8, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(num1, m, nums2, n);
        System.out.println(Arrays.toString(num1));
    }
}
