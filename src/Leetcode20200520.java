import java.util.Arrays;

public class Leetcode20200520 {

    public static int findKthLargest(int[] nums, int k) {
        // 将数组排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                count++;
            }
            if (count == k) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //[3,2,3,1,2,4,5,5,6]
        //4
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}


