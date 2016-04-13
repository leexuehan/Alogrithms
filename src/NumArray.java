/**
 * Created by lixuehan on 16/4/13.
 */
/**
 * Created by lixuehan on 16/4/13.
 */
public class NumArray {

    public int[] vars;

    public NumArray(int[] nums) {
        vars = nums;
    }

    public int sumRange(int i, int j) {
        int result = vars[i];
        if(i == j) return result;
        for(int k = i + 1; k <= j; k++)
            result += vars[k];
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numarray = new NumArray(nums);
        int result = numarray.sumRange(2,5);
        System.out.println(result);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);