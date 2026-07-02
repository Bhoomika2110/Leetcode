class Solution {
    public int maxProduct(int[] nums) {
        int maxprod = nums[0];
        int minprod = nums[0];
        int result = nums[0];

        for(int i = 1; i<nums.length; i++){
            int num = nums[i];

            if(num < 0) {
                int temp = maxprod;
                maxprod = minprod;
                minprod = temp;
            }
            maxprod = Math.max(num , maxprod *num);
            minprod = Math.min(num , minprod *num);

            result = Math.max(result , maxprod);
        }
        return result;
    }

}