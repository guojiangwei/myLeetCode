/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    /**
     * 1,将nums1中的元素拷贝到临时数组
     * 2，用两个指针分别指向临时数组和数组二，谁的元素小就把谁拷贝到数组一，并移动指针
     * 3，根据指针位置判断临时数组和数组二剩余的元素，并全部拷贝到nums1
     * 0ms    100%      48%   38.9MB
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m];
        System.arraycopy(nums1, 0, tmp, 0, m);
        int i=0, j=0;
        while(i<m && j<n){
            if(tmp[i]<nums2[j]){
                nums1[i+j] = tmp[i++];
            }else{
                nums1[i+j] = nums2[j++];
            }
        }
        if(i == m)System.arraycopy(nums2, j, nums1, i+j, n-j);
        if(j == n)System.arraycopy(tmp, i, nums1, i+j, m-i);
    }

    /**
     * 1,题目以及假设nums1 长度有m+2
     * 2，将nums1的数字全部拷贝到数组尾部，nums1的前n个元素可以直接覆盖
     * 3，从nums1的第n个元素跟nums第一个元素开始比对
     * 0ms 100%   12%    39.2MB
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums1, 0, nums1, n, m);
        int i=0,j=n;
        while(i<n && j<m+n){
            if(nums1[j]<nums2[i]){
                nums1[i+j-n] = nums1[j++];
                
            }else{
                nums1[i+j-n] = nums2[i++];
            }
        }
        if(j==m+n)System.arraycopy(nums2, i, nums1, i+j-n, n-i);
        
    }
    /**
     * 双指针
     * 从最大值开始比对，好处是省略了很多交换，也省略了临时空间
     * 0 100%  32%   39MB
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n - 1;
        while(j>=0){
            if(i>=0 && nums1[i]>nums2[j]){
                nums1[i+j+1] = nums1[i--];
            }else{
                nums1[i+j+1] = nums2[j--];
            }
        }

    }
}
// @lc code=end

